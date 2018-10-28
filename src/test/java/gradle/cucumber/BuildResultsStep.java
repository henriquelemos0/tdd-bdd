package gradle.cucumber;

import com.f1.results.input.model.ResultBoard;
import com.f1.results.input.model.ResultBoardEntry;
import com.f1.results.input.model.ResultBuilder;
import com.f1.results.input.model.ResultEntry;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BuildResultsStep {

    private ResultBuilder resultBuilder = new ResultBuilder();
    private ResultBoard resultBoard;

    @Given("^the following laps:$")
    public void theFollowingLaps(final List<ResultEntry> resultEntryList) throws Throwable {
        for (ResultEntry resultEntry : resultEntryList) {
            resultBuilder.add(
                    new ResultEntry(resultEntry.getPilotCode(), resultEntry.getPilotName(), resultEntry.getLap(), resultEntry.getLapTime(), resultEntry.getAvgLapSpeed())
            );
        }
    }

    @When("^the results are built$")
    public void buildResultBoard() {
        resultBoard = resultBuilder.buildResultBoard();
    }

    @Then("^the result board is:$")
    public void theResultBoardIs(final List<ResultBoardEntry> expectedResultBoardEntryList) throws Throwable {
        List<ResultBoardEntry> resultBoardEntryList = resultBoard.getResultBoardEntries();
        for (int i = 0; i < expectedResultBoardEntryList.size(); i++) {
            assertEquals(expectedResultBoardEntryList.get(i).getFinalPosition(), resultBoardEntryList.get(i).getFinalPosition());
            assertEquals(expectedResultBoardEntryList.get(i).getPilotCode(), resultBoardEntryList.get(i).getPilotCode());
            assertEquals(expectedResultBoardEntryList.get(i).getPilotName(), resultBoardEntryList.get(i).getPilotName());
            assertEquals(expectedResultBoardEntryList.get(i).getCompletedLaps(), resultBoardEntryList.get(i).getCompletedLaps());
            assertEquals(expectedResultBoardEntryList.get(i).getTotalElapsedTime(), resultBoardEntryList.get(i).getTotalElapsedTime());
        }
    }

}
