package com.affinitysquare.parser.response;

import com.affinitysquare.parser.data.LinkType;
import com.google.common.net.InternetDomainName;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.nodes.Document;

import java.net.URI;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LinkCountExtractor implements HtmlDataExtractor<Map<LinkType, Integer>> {
    private final Log log = LogFactory.getLog(LinkCountExtractor.class);

    /**
     * Extract the links and count the internal and external links. Internal links has the same domain as the given
     * url but external links has different domain
     * @param document Jsoup document object
     * @return EnumMap of LinkType and total count of each type
     */
    @Override
    public Map<LinkType, Integer> extract(Document document) {
        EnumMap<LinkType, Integer> map = new EnumMap<>(LinkType.class);
        map.put(LinkType.INTERNAL, 0);
        map.put(LinkType.EXTERNAL, 0);

        List<String> links = LinkExtractorHelper.extract(document);
        for(String link : links){
            matchAndUpdate(map, link, document);
        }
        return map;
    }

    private void matchAndUpdate(EnumMap<LinkType, Integer> map, String link, Document doc){
        try {
            String hostDomain = InternetDomainName.from(new URI(doc.baseUri()).getHost()).topPrivateDomain().toString();
            String linkDomain = InternetDomainName.from(new URI(link).getHost()).topPrivateDomain().toString();
            if(hostDomain.equals(linkDomain)){
                map.put(LinkType.INTERNAL, map.get(LinkType.INTERNAL) + 1);
            } else {
                map.put(LinkType.EXTERNAL, map.get(LinkType.EXTERNAL) + 1);
            }
        } catch (Exception e){
            log.error("Exception occurred while parsing links", e);
        }
    }

}