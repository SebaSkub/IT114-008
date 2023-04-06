package Milestone2.common;

import java.io.Serializable;

public class Payload implements Serializable {
    // read https://www.baeldung.com/java-serial-version-uid
    private static final long serialVersionUID = 1L;// change this if the class changes

    /**
     * Determines how to process the data on the receiver's side
     */
    private PayloadType payloadType;

    public PayloadType getPayloadType() {
        return payloadType;
    }

    public void setPayloadType(PayloadType payloadType) {
        this.payloadType = payloadType;
    }

    /**
     * Who the payload is from
     */
    //ss365
    //April 5th, 2023  
    private String clientName;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    private long clientId;

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    /**
     * Generic text based message
     */
    //ss365
    //April 5th, 2023  
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //ss365
    //April 5th, 2023  
    //Type used for Static and Boolean
    //ClientID server thread
    //ClientName for username
    //Message see message before styling
    @Override
    public String toString() {
        return String.format("Type[%s],ClientId[%s], ClientName[%s], Message[%s]", getPayloadType().toString(),
                getClientId(), getClientName(),getMessage());
    }
}