package com.example.elsearch.access;

import com.example.elsearch.data.EsSearchResult;
import com.example.elsearch.data.Item;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 * Elasticsearch access service implementation.
 */
@Service
public class ESAccessServiceImpl implements ESAccessService {
    private static final String NILS_TEST_INDEX = "nils_test_index";
    private static final String TITLE = "title";
    private static final String LINK = "link";
    private static final String PUB_DATE = "pubDate";
    private static final String COMMENTS = "comments";
    private static final String DESCRIPTION = "description";

    private final ESClientProvider provider;

    public ESAccessServiceImpl(ESClientProvider provider) {
        this.provider = provider;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EsSearchResult fetch(String query) throws IOException {
        SearchRequest searchRequest = new SearchRequest(NILS_TEST_INDEX);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder(TITLE, query);

        searchSourceBuilder.query(matchQueryBuilder);

        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = provider.restHighLevelClient().search(searchRequest, RequestOptions.DEFAULT);

        SearchHits hits = searchResponse.getHits();

        EsSearchResult result = new EsSearchResult();

        for (SearchHit hit : hits) {
            Map<String, Object> map = hit.getSourceAsMap();

            Item item = new Item();
            item.setTitle(map.get(TITLE).toString());
            item.setLink(map.get(LINK).toString());
            item.setComments(map.get(COMMENTS).toString());
            item.setPubDate(map.get(PUB_DATE).toString());
            item.setDescription(map.get(DESCRIPTION).toString());

            result.getItems().add(item);
        }

        return result;
    }
}
