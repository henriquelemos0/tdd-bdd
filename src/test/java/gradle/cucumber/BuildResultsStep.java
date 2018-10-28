package gradle.cucumber;

import com.f1.results.model.LapEntry;
import com.f1.results.model.ResultBoardEntry;
import com.f1.results.service.PodiumService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BuildResultsStep {

    private PodiumService podiumService = new PodiumService();

    @Given("^the following laps:$")
    public void theFollowingLaps(final List<LapEntry> lapEntryList) throws Throwable {
        for (LapEntry lapEntry : lapEntryList) {
            podiumService.add(
                    new LapEntry(lapEntry.getPilotCode(), lapEntry.getPilotName(), lapEntry.getLap(), lapEntry.getLapTime(), lapEntry.getAvgLapSpeed())
            );
        }
    }

    @When("^the results are built$")
    public void calculateResultBoard() {
        podiumService.calculateResultBoard();
    }

    @Then("^the result board is:$")
    public void theResultBoardIs(final List<ResultBoardEntry> expectedResultBoardEntryList) throws Throwable {
        List<ResultBoardEntry> resultBoardEntryList = podiumService.getResultBoardEntries();
        for (int i = 0; i < expectedResultBoardEntryList.size(); i++) {
            assertEquals(expectedResultBoardEntryList.get(i).getFinalPosition(), resultBoardEntryList.get(i).getFinalPosition());
            assertEquals(expectedResultBoardEntryList.get(i).getPilotCode(), resultBoardEntryList.get(i).getPilotCode());
            assertEquals(expectedResultBoardEntryList.get(i).getPilotName(), resultBoardEntryList.get(i).getPilotName());
            assertEquals(expectedResultBoardEntryList.get(i).getCompletedLaps(), resultBoardEntryList.get(i).getCompletedLaps());
            assertEquals(expectedResultBoardEntryList.get(i).getTotalElapsedTime(), resultBoardEntryList.get(i).getTotalElapsedTime());
        }
    }

}
