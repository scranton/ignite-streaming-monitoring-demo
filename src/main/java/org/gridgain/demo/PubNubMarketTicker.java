package org.gridgain.demo;

import com.pubnub.api.PNConfiguration;
import com.pubnub.api.PubNub;

import java.util.List;

public class PubNubMarketTicker implements MarketTicker {
    /**
     * PubNub stream name.
     */
    protected final static String STREAM_NAME = "pubnub-market-orders";
    /**
     * Stream object.
     */
    private PubNub stream;
    /**
     * PubNub stream subscription key.
     */
    private final String STREAM_SUBSCRIPTION_KEY = "sub-c-4377ab04-f100-11e3-bffd-02ee2ddab7fe";

    private final StreamCallback streamCallback;

    public PubNubMarketTicker(StreamCallback streamCallback) {
        this.streamCallback = streamCallback;
    }

    public void start() {
        PNConfiguration cfg = new PNConfiguration();
        cfg.setSubscribeKey(STREAM_SUBSCRIPTION_KEY);

        stream = new PubNub(cfg);

        stream.addListener(streamCallback);
        stream.subscribe().channels(List.of(STREAM_NAME)).execute();
    }

    public void stop() {
        stream.unsubscribe().execute();
    }

}
