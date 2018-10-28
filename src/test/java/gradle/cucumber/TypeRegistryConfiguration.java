package gradle.cucumber;

import com.f1.results.input.model.ResultBoardEntry;
import com.f1.results.input.model.ResultEntry;
import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;

import java.util.Locale;

public class TypeRegistryConfiguration implements TypeRegistryConfigurer {

    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(DataTableType.entry(ResultBoardEntry.class));
        typeRegistry.defineDataTableType(DataTableType.entry(ResultEntry.class));

    }
}
