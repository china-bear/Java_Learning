package concurrency.heima.n2;

import concurrency.heima.Constants;
import concurrency.heima.n2.util.FileReader;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Sync")
public class Sync {

    public static void main(String[] args) {
        FileReader.read(Constants.MP4_FULL_PATH);
        log.debug("do other things ...");
    }

}
