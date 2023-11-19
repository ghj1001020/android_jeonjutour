package com.ghj.jeonjutour.dto;

import com.tickaroo.tikxml.annotation.Attribute;
import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

import java.util.ArrayList;
import java.util.List;

@Xml(name = "rfcOpenApi")
public class CultureExpDto {

    @Element(name = "header")
    public Header header;
    @Element(name = "body")
    public Body body;

    @Xml(name = "header")
    public static class Header {
        @PropertyElement(name = "resultCode")
        public String resultCode;
        @PropertyElement(name = "resultMsg")
        public String resultMsg;

    }

    @Xml(name = "body")
    public static class Body {
        @PropertyElement(name = "pageIndex")
        public String pageIndex;
        @PropertyElement(name = "pageSize")
        public String pageSize;
        @PropertyElement(name = "startPage")
        public String startPage;
        @PropertyElement(name = "totalCount")
        public String totalCount;
        @Element(name = "data")
        public DataItems data;
    }

    @Xml(name = "data")
    public static class DataItems {
        @Element(name = "list")
        List<DataItem> item;
    }

    @Xml
    public static class DataItem {
        @PropertyElement(name = "addr")
        public String addr;
        @PropertyElement(name = "addrDtl")
        public String addrDtl;
        @PropertyElement(name = "boardSid")
        public String boardSid;
        @PropertyElement(name = "charge")
        public String charge;
        @PropertyElement(name = "cultureSpNm")
        public String cultureSpNm;
        @PropertyElement(name = "dataContent")
        public String dataContent;
        @PropertyElement(name = "dataSid")
        public String dataSid;
        @PropertyElement(name = "dataTitle")
        public String dataTitle;
        @PropertyElement(name = "expCommente")
        public String expCommente;
        @PropertyElement(name = "experName")
        public String experName;

        @PropertyElement(name = "fileCnt")
        public String fileCnt;
        @PropertyElement(name = "homepage")
        public String homepage;
        @PropertyElement(name = "lowCost")
        public String lowCost;
        @PropertyElement(name = "maxCost")
        public String maxCost;
        @PropertyElement(name = "memberCnt")
        public String memberCnt;
        @PropertyElement(name = "posx")
        public String posx;
        @PropertyElement(name = "posy")
        public String posy;
        @PropertyElement(name = "reqTime")
        public String reqTime;
        @PropertyElement(name = "tel")
        public String tel;
        @PropertyElement(name = "zipcode")
        public String zipcode;
    }
}
