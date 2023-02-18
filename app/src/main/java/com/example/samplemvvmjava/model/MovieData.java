package com.example.samplemvvmjava.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieData {
    
    public String movieCd;
    public String movieNm;
    public String prdtYear;
    public String openDt;
    public String typeNm;
    public String genreAlt;
    public String peopleNm;
    public String companyNm;

    public List<PeopleNm> directors;
    public List<CompanyNm> companys;


    public String getMainDirector(){
        if(directors != null && directors.size() > 0)
            return directors.get(0).peopleNm;
        return "감독정보 없음";
    }

    public String getMainCompany(){
        if(companys != null && companys.size() > 0)
            return companys.get(0).companyNm;
        return "제작사 정보 없음";
    }


}
