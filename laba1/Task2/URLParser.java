package org.example;


public class URLParser {

    public SimpleUrl parse(String url) {
        SimpleUrl simpleUrl = new SimpleUrl();

        try {
            String[] urlParts = url.split("://");
            simpleUrl.setProtocol(urlParts[0]);

            String[] addressParts = urlParts[1].split("/", 2);
            simpleUrl.setAddress(addressParts[0]);

            String[] domainParts = addressParts[0].split("\\.");
            simpleUrl.setSiteName(domainParts[0]);
            simpleUrl.setDomainZone(domainParts[1]);

            String[] pageParts = addressParts[1].split("\\?", 2);
            String[] webpageParts = pageParts[0].split("\\.");
            simpleUrl.setWebpageName(webpageParts[0]);
            simpleUrl.setWebPageExtension(webpageParts[1]);

        } catch (Exception e) {
            System.out.println("Ошибка при парсинге URL: " + e.getMessage());
        }

        return simpleUrl;
    }
}
