package gildedrose;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class GoldenMasterTest {

    @Test
    void equalsGoldenMaster() throws Exception {
        try (var stream = new PrintStream(Path.of("output.txt").toFile())) {
            System.setOut(stream);

            TextTestFixture.main(new String[0]);
        }

        // assert but keep the output. I use the IDE to compare the full file.
        // (Select golden-master.txt and output.txt and press ctrl-D)
        var actual = Files.readAllLines(Paths.get("output.txt"));
        var goldenMaster = Files.readAllLines(Paths.get("golden-master.txt"));

        for (var i = 0; i < goldenMaster.size(); i++) {
            assertThat(actual.get(i))
                    .withFailMessage("Line %s: expected [%s] but was [%s]", i, goldenMaster.get(i), actual.get(i))
                    .isEqualTo(goldenMaster.get(i));
        }

    }
}
