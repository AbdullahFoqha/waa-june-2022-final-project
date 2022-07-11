package edu.miu.waabackend.config;

public enum RoutingValues {
    QUEUE_ONE("first_queue"),
    EXCHANGE_ONE("first_exchange"),
    ROUTING_KEY_ONE("first_routing_key");

    private final String text;

    RoutingValues(final String text){
        this.text = text;
    }

    @Override
    public String toString(){
        return text;
    }
}
