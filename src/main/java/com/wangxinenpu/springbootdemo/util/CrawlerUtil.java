package com.wangxinenpu.springbootdemo.util;

import com.wangxinenpu.springbootdemo.dataobject.Institution;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class CrawlerUtil {


    public static void main(String[] args) {

    }

    public static List<Institution> getInsStringList(Elements elements) {
        List<Institution> institutions= elements.stream().map(i->{
                Institution institution=new Institution();
                institution.setBankCode(i.getElementsByTag("td").get(0).text());
            institution.setName(i.getElementsByTag("td").get(1).text());
            institution.setPhone(i.getElementsByTag("td").get(2).text());
            institution.setMailCode(i.getElementsByTag("td").get(3).text());
            institution.setAdredd(i.getElementsByTag("td").get(4).text());
            institution.setSWIFT(i.getElementsByTag("td").get(5).text());
            return institution;
        }).collect(Collectors.toList());
        institutions.forEach(i-> System.out.println(i));
        return institutions;
    }

    public static Elements getTableString(String totalReturnStr) {
        String start = "<table class=\"table\">";
        String end = "</table>";
        int s = totalReturnStr.indexOf(start) + start.length();
        int e = totalReturnStr.indexOf(end);
        String tableString=totalReturnStr.substring(s, e);
        System.out.println(tableString);
        Document doc = Jsoup.parseBodyFragment(totalReturnStr);
        Elements elements=doc.getElementsByTag("tr");
        Iterator<Element> iterator=elements.iterator();
        while (iterator.hasNext()){
            Element element=iterator.next();
            if (element.getElementsByTag("td")==null||element.getElementsByTag("td").isEmpty()){
                iterator.remove();
            }
        }
//        elements.stream().forEach(i->            System.out.println(i.getElementsByTag("td").get(0).text()));
        return elements;
    }

}
