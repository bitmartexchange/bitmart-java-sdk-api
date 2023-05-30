package com.bitmart.api.request;

/**
 * The authentication type of each API endpoint will be indicated.
 * If it is marked as SIGNED,it means that the endpoint requires a signature to access.
 * If it is marked as KEYED, it means that the endpoint only requires an API Access KEY to be set in the request header.
 *
 */
public enum Auth {

    /**
     * Public endpoint, accessible to anyone
     */
    NONE(),

    /**
     * Endpoint requires a valid X-BM-KEY to be set in the request header
     */
    KEYED(),

    /**
     * Endpoint requires a valid X-BM-KEY
     *      and X-BM-SIGN signature to be set in the request header
     */
    SIGNED();
}
