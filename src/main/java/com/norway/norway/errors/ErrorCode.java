package com.norway.norway.errors;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public enum ErrorCode {
    EDITOR_NOT_UPLOAD("700", "에디터 이미지 업로드를 실패했습니다.", null),
    //어드민 검색
    ADMIN_NOT_SEARCH("701", "어드민 검색을 실패했습니다.",  null),
    ADMIN_NOT_INSERT("702", "어드민 등록을 실패했습니다.",  null),
    ADMIN_NOT_UPDATE("703", "어드민 수정을 실패했습니다.",  null),
    ADMIN_NOT_UPDATE_ROLE("704", "어드민 수정 권한이 없습니다.",  null),

    COUPON_NOT_INSERT_TITLE("801", "쿠폰 제목을 확인 해주십시오.",  null),
    COUPON_NOT_INSERT_DESCRIPTION("802", "쿠폰 설명글을 확인 해주십시오.",  null),
    COUPON_NOT_INSERT_CODE("803", "쿠폰 코드를 확인 해주십시오.",  null),
    COUPON_NOT_INSERT_REDUNDANCY("804", "증복 쿠폰 코드 입니다.",  null),
    COUPON_NOT_INSERT_USER("805", "지급 대상을 선택 해주세요.",  null),
    COUPON_NOT_DELETE_USER("806", "회수할 쿠폰을 선택 해주세요.",  null),

    RACE_NOT_UPDATE_RACENO("901", "레이스를 선택 해주세요",  null),
    RACE_NOT_INSERT_RACE("902", "레이스 등록을 실패했습니다.",  null),
    RACE_NOT_INSERT_RACE_FILE("903", "레이스 파일을 확인 해주세요.",  null),
    RACE_NOT_UPDATE_RACE("904", "레이스 등록을 실패했습니다.",  null),
    RACE_NOT_UPDATE_ADMIN("905", "등록한 관리자와 수정할 관리자가 다릅니다.",  null),
    RACE_NOT_RACE_START_DATE("906", "레이스 시작일을 선택하세요.",  null),
    RACE_NOT_RACE_END_DATE("907", "레이스 종료일을 선택하세요.",  null),
    RACE_NOT_EARLY_START_DATE("908", "얼리버드 시작일을 선택하세요.",  null),
    RACE_NOT_EARLY_END_DATE("909", "얼리버드 종료일을 선택하세요.",  null),

    RACE_NOT_WEEK_START_DATE("1001", "레이스 시작일을 선택하세요.",  null),
    RACE_NOT_WEEK_END_DATE("1002", "레이스 종료일을 선택하세요.",  null),

    ADMIN_NOT_CHK_PASSWORD("1101", "변경 비밀번호 확인비밀번호를 확인 해주세요.",  null),
    ADMIN_NOT_UPD_PASSWORD("1102", "비밀번호 변경을 실패했습니다.",  null),
    ADMIN_NOT_REDUNDANCY("1103", "중복된 아이디입니다.",  null),
    ADMIN_NOT_REDUNDANCY_PASSWORD("1104", "비밀번호 또는 확인 비밀번호를 확인 해주세요.",  null),

    CONTENT_NOT_TAG("1201", "태그가 3개이상이 아닙니다.",  null),

    BADGE_TYPE_NOT_TITLE("1301", "중복된 배지 타입 입니다.",  null),
    BADGE_NOT_TITLE("1302", "중복된 배지 입니다.",  null),

    VOD_NOT_TAG_SIZE("1401", "태그가 3개이상이 아닙니다.",  null),
    VOD_NOT_EPISODE_SIZE("1402", "선택된 에피소드가 없습니다.",  null),

    BLOG_NOT_START_DATE("1501", "블로그 시작일을 선택하세요.",  null),
    BLOG_NOT_END_DATE("1502", "블로그 종료일을 선택하세요.",  null),

    PRODUCT_NOT_TYPE("1601", "상품 타입이 올바르지 않습니다.",  null),

    PRODUCT_NOT_CODE("1701", "중복된 상품코드 입니다.",  null),

    TAG_NOT_TITLE("1801", "중복된 태그 입니다.",  null),
    TAG_FIRST_ORDER("1802", "첫번째 태그 순서 입니다.",  null),
    TAG_LAST_ORDER("1803", "마지막 태그 순서 입니다.",  null),

    CURATED_FIRST_ORDER("1901", "첫번째 순서 입니다.",  null),
    CURATED_LAST_ORDER("1902", "마지막 순서 입니다.",  null),
    CURATED_NOT_TYPE("1903", "타입 오류 입니다.",  null),
    CURATED_NOT_COUNT("1904", "최대 등록 개수는 5개입니다.",  null),
    CURATED_NOT_STATUS("1905", "비활성화 데이터 입니다.",  null),

    BANNER_NOT_CONNECTION_TYPE("2001", "대분류 타입이 올바르지 않습니다.",  null),
    BANNER_NOT_TYPE("2002", "타입이 올바르지 않습니다.",  null),
    BANNER_EXISTENCE("2003", "이미 레이스 배너가 존재합니다.", null),
    BANNER_NOT_EXISTENCE("2004", "이미 레이스종료 배너가 존재합니다.", null),
    BANNER_NOT_STATUS("2005", "배너 상태가 올바르지 않습니다.", null),


    PAYMENT_TEXT_BLANK("2101", "해당 문구가 올바르지 않습니다.", null),

    TEXT_FIRST_ORDER("2201", "첫번째 순서 입니다.", null),
    TEXT_LAST_ORDER("2202", "마지막 순서 입니다.", null),


    EXCEL_UPLOAD("8000", "엑셀 업로드가 실패 했습니다.", null),


    SMS_FILE_CONVERT_FAIL("9992", "SMS FILE CONVERT 실패",  null),
    NOT_PAGE("9994", "페이지가 존재하지 않습니다.", null),
    AMAZON_S3_FILE_UPLOAD_FAIL("9995", "AWS S3 파일 업로드 실패.",  null),

    NOT_FILE_SIZE("9996", "파일 갯수를 확인 해주세요.", null),
    NOT_EXTENSION("9997", "올바른 확장자가 아닙니다.", null),
    NOT_FILE("9998", "파일을 등록 해주세요.", null),
    FAILED("9999", "Unexpected Error", null);

    private static final Map<String, ErrorCode> errorMap =
            Arrays.stream(values()).collect(Collectors.toMap(ErrorCode::getCode, e->e));

    public static ErrorCode findByCode(String code) {
        return errorMap.get(code);
    }

    private String code;
    private String errorMsg;
    private String redirectUrl;

    ErrorCode(String code, String msg, String url) {
        this.code = code;
        this.errorMsg = msg;
        this.redirectUrl = url;
    }

    public String getCode() { return code; }
    public void setCode(String code) {
        this.code = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public Map<String, String> getErrorMap() {
        return new HashMap<>(){{
            put("code", code);
            put("message", errorMsg);
        }};
    }

    public String getErrorString() {
        return getErrorJson().toString();
    }

    public JSONObject getErrorJson() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("code", code);
            jsonObject.put("message", errorMsg);
        }
        catch (JSONException ignore) {}
        return jsonObject;
    }

    public String getCustomErrorCodeStr() {
        return "ERRORCODE_" + this.code;
    }
}