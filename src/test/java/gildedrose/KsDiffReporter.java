package gildedrose;

import org.approvaltests.reporters.DiffInfo;
import org.approvaltests.reporters.GenericDiffReporter;

public class KsDiffReporter extends GenericDiffReporter {

    public KsDiffReporter() {
        super(new DiffInfo("/usr/local/bin/ksdiff",
                "%s %s", GenericDiffReporter.TEXT_FILE_EXTENSIONS));
    }
}
