package helper.methods;

import helper.ApiHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PatchHelper {

    private final Logger log = LogManager.getLogger(PatchHelper.class);

    /**
     * Create a patch request and update ApiHelper class' response object.
     *
     * @param url url to which the request will be sent
     */
    protected void patchRequest(String url) {
        var response = ApiHelper.getInstance().getRequestSpecification().patch(url)
                .then()
                .extract()
                .response();
        ApiHelper.getInstance().setResponse(response);
        ApiHelper.getInstance().defineNewRequest();
        log.info("Patch request sent to {}", url);
    }

    /**
     * Create a patch request and update ApiHelper class' response object.
     */
    protected void patchRequest() {
        var response = ApiHelper.getInstance().getRequestSpecification().patch()
                .then()
                .extract()
                .response();
        ApiHelper.getInstance().setResponse(response);
        ApiHelper.getInstance().defineNewRequest();
        log.info("Patch request sent");
    }
}
