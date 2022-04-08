package api;

import aquality.selenium.core.logging.Logger;
import enums.QueryParamsKeys;
import enums.QueryParamsValues;
import enums.StatusCode;
import io.restassured.http.ContentType;
import models.Tests;
import utils.BufferedReaderUtils;
import utils.EncodeUtils;
import utils.FileUtils;

import java.util.List;

import static constants.ResourcesPath.*;
import static io.restassured.RestAssured.given;
import static utils.RandomGenerator.randomProjectName;
import static utils.ScreenShotUtils.getScreenshotFile;
import static utils.TestingConfigurations.*;

public class ApiMethods {

    public static String getKey() {
        return given().auth()
                .basic(getDataFromResources(TESTING_PATH, "/basicAuthLogin"), getDataFromResources(TESTING_PATH, "/basicAuthPassword"))
                .when()
                .post(getDataFromResources(CONFIG_PATH, "/postBody"))
                .then()
                .assertThat()
                .statusCode(StatusCode.OK.getCode())
                .extract().body().asString();
    }

    public static List<Tests> getTestListFromApi() {
        return given()
                .baseUri(API_HOST)
                .basePath(getDataFromResources(ENDPOINT_PATH, "/getJson"))
                .contentType(ContentType.JSON)
                .queryParam(QueryParamsKeys.PROJECT_ID.getParamKey(), 1)
                .when().post()
                .then().statusCode(StatusCode.OK.getCode())
                .extract().body().jsonPath().getList(".", Tests.class);
    }

    public static void setLogs(String testId) {
        given()
                .baseUri(API_HOST)
                .basePath(getDataFromResources(ENDPOINT_PATH, "/getLog"))
                .formParam(QueryParamsKeys.TEST_ID.getParamKey(), testId)
                .formParam(QueryParamsKeys.CONTENT.getParamKey(), BufferedReaderUtils.readUsingBufferedReader(FileUtils.getLogFile()))
                .formParam(QueryParamsKeys.CONTENT_TYPE.getParamKey(), QueryParamsValues.TEXT.getParamValue())
                .when().post()
                .then().statusCode(StatusCode.OK.getCode());
    }

    public static void createNewTestWithLogsAndAttachment(String SID, String projectName,
                                                          String testName, String methodName) {
        String testId = createTest(SID, projectName, testName, methodName);
       // setLogs(testId);
        setScreenshot(testId);
        Logger.getInstance().info("created log and screenshot");
    }

    public static String createTest(String SID, String projectName, String testName, String methodName) {
        return given()
                .baseUri(API_HOST)
                .basePath(getDataFromResources(ENDPOINT_PATH, "/putTest"))
                .contentType(ContentType.JSON)
                .queryParam(QueryParamsKeys.SID.getParamKey(), SID)
                .queryParam(QueryParamsKeys.PROJECT_NAME.getParamKey(), randomProjectName)
                .queryParam(QueryParamsKeys.TEST_NAME.getParamKey(), testName)
                .queryParam(QueryParamsKeys.METHOD_NAME.getParamKey(), methodName)
                .queryParam(QueryParamsKeys.ENV.getParamKey(), API_HOST)
                .when().post()
                .then().statusCode(StatusCode.OK.getCode())
                .extract().body().asString();
    }

    public static void setScreenshot(String testId) {
        given()
                .baseUri(API_HOST)
                .basePath(getDataFromResources(ENDPOINT_PATH, "/putAttach"))
                .formParam(QueryParamsKeys.TEST_ID.getParamKey(), testId)
                .formParam(QueryParamsKeys.CONTENT.getParamKey(), EncodeUtils.encodeFileToBase64Binary(getScreenshotFile()))
                .formParam(QueryParamsKeys.CONTENT_TYPE.getParamKey(), QueryParamsValues.IMAGE.getParamValue())
                .when().post()
                .then().statusCode(StatusCode.OK.getCode());
    }

 }
