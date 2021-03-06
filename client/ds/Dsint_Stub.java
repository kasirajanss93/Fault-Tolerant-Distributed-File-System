// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JAX-RPC Standard Implementation (1.1.3, build R1)
// Generated source version: 1.1.3

package ds;

import com.sun.xml.rpc.server.http.MessageContextProperties;
import com.sun.xml.rpc.streaming.*;
import com.sun.xml.rpc.encoding.*;
import com.sun.xml.rpc.encoding.soap.SOAPConstants;
import com.sun.xml.rpc.encoding.soap.SOAP12Constants;
import com.sun.xml.rpc.encoding.literal.*;
import com.sun.xml.rpc.soap.streaming.*;
import com.sun.xml.rpc.soap.message.*;
import com.sun.xml.rpc.soap.SOAPVersion;
import com.sun.xml.rpc.soap.SOAPEncodingConstants;
import com.sun.xml.rpc.wsdl.document.schema.SchemaConstants;
import javax.xml.namespace.QName;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.lang.reflect.*;
import java.lang.Class;
import com.sun.xml.rpc.client.SenderException;
import com.sun.xml.rpc.client.*;
import com.sun.xml.rpc.client.http.*;
import javax.xml.rpc.handler.*;
import javax.xml.rpc.JAXRPCException;
import javax.xml.rpc.soap.SOAPFaultException;

public class Dsint_Stub
    extends com.sun.xml.rpc.client.StubBase
    implements ds.Dsint {
    
    
    
    /*
     *  public constructor
     */
    public Dsint_Stub(HandlerChain handlerChain) {
        super(handlerChain);
        _setProperty(ENDPOINT_ADDRESS_PROPERTY, "http://Kasi-PC:60888/kasi/Rajan");
    }
    
    
    /*
     *  implementation of getvideo
     */
    public byte[] getvideo(java.lang.String string_1)
        throws java.rmi.RemoteException {
        
        try {
            
            StreamingSenderState _state = _start(_handlerChain);
            
            InternalSOAPMessage _request = _state.getRequest();
            _request.setOperationCode(getvideo_OPCODE);
            ds.Dsint_getvideo_RequestStruct _myDsint_getvideo_RequestStruct =
                new ds.Dsint_getvideo_RequestStruct();
            
            _myDsint_getvideo_RequestStruct.setString_1(string_1);
            
            SOAPBlockInfo _bodyBlock = new SOAPBlockInfo(ns1_getvideo_getvideo_QNAME);
            _bodyBlock.setValue(_myDsint_getvideo_RequestStruct);
            _bodyBlock.setSerializer(ns1_myDsint_getvideo_RequestStruct_SOAPSerializer);
            _request.setBody(_bodyBlock);
            
            _state.getMessageContext().setProperty(HttpClientTransport.HTTP_SOAPACTION_PROPERTY, "");
            
            _send((java.lang.String) _getProperty(ENDPOINT_ADDRESS_PROPERTY), _state);
            
            ds.Dsint_getvideo_ResponseStruct _myDsint_getvideo_ResponseStruct = null;
            Object _responseObj = _state.getResponse().getBody().getValue();
            if (_responseObj instanceof SOAPDeserializationState) {
                _myDsint_getvideo_ResponseStruct =
                    (ds.Dsint_getvideo_ResponseStruct)((SOAPDeserializationState)_responseObj).getInstance();
            } else {
                _myDsint_getvideo_ResponseStruct =
                    (ds.Dsint_getvideo_ResponseStruct)_responseObj;
            }
            
            return _myDsint_getvideo_ResponseStruct.getResult();
        } catch (RemoteException e) {
            // let this one through unchanged
            throw e;
        } catch (JAXRPCException e) {
            throw new RemoteException(e.getMessage(), e);
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                throw (RuntimeException)e;
            } else {
                throw new RemoteException(e.getMessage(), e);
            }
        }
    }
    
    
    /*
     *  this method deserializes the request/response structure in the body
     */
    protected void _readFirstBodyElement(XMLReader bodyReader, SOAPDeserializationContext deserializationContext, StreamingSenderState  state) throws Exception {
        int opcode = state.getRequest().getOperationCode();
        switch (opcode) {
            case getvideo_OPCODE:
                _deserialize_getvideo(bodyReader, deserializationContext, state);
                break;
            default:
                throw new SenderException("sender.response.unrecognizedOperation", java.lang.Integer.toString(opcode));
        }
    }
    
    
    
    /*
     * This method deserializes the body of the getvideo operation.
     */
    private void _deserialize_getvideo(XMLReader bodyReader, SOAPDeserializationContext deserializationContext, StreamingSenderState state) throws Exception {
        java.lang.Object myDsint_getvideo_ResponseStructObj =
            ns1_myDsint_getvideo_ResponseStruct_SOAPSerializer.deserialize(ns1_getvideo_getvideoResponse_QNAME,
                bodyReader, deserializationContext);
        
        SOAPBlockInfo bodyBlock = new SOAPBlockInfo(ns1_getvideo_getvideoResponse_QNAME);
        bodyBlock.setValue(myDsint_getvideo_ResponseStructObj);
        state.getResponse().setBody(bodyBlock);
    }
    
    
    
    public java.lang.String _getDefaultEnvelopeEncodingStyle() {
        return SOAPNamespaceConstants.ENCODING;
    }
    
    public java.lang.String _getImplicitEnvelopeEncodingStyle() {
        return "";
    }
    
    public java.lang.String _getEncodingStyle() {
        return SOAPNamespaceConstants.ENCODING;
    }
    
    public void _setEncodingStyle(java.lang.String encodingStyle) {
        throw new UnsupportedOperationException("cannot set encoding style");
    }
    
    
    
    
    
    /*
     * This method returns an array containing (prefix, nsURI) pairs.
     */
    protected java.lang.String[] _getNamespaceDeclarations() {
        return myNamespace_declarations;
    }
    
    /*
     * This method returns an array containing the names of the headers we understand.
     */
    public javax.xml.namespace.QName[] _getUnderstoodHeaders() {
        return understoodHeaderNames;
    }
    
    public void _initialize(InternalTypeMappingRegistry registry) throws Exception {
        super._initialize(registry);
        ns1_myDsint_getvideo_ResponseStruct_SOAPSerializer = (CombinedSerializer)registry.getSerializer(SOAPConstants.NS_SOAP_ENCODING, ds.Dsint_getvideo_ResponseStruct.class, ns1_getvideoResponse_TYPE_QNAME);
        ns1_myDsint_getvideo_RequestStruct_SOAPSerializer = (CombinedSerializer)registry.getSerializer(SOAPConstants.NS_SOAP_ENCODING, ds.Dsint_getvideo_RequestStruct.class, ns1_getvideo_TYPE_QNAME);
    }
    
    private static final javax.xml.namespace.QName _portName = new QName("urn:ds", "dsintPort");
    private static final int getvideo_OPCODE = 0;
    private static final javax.xml.namespace.QName ns1_getvideo_getvideo_QNAME = new QName("urn:ds", "getvideo");
    private static final javax.xml.namespace.QName ns1_getvideo_TYPE_QNAME = new QName("urn:ds", "getvideo");
    private CombinedSerializer ns1_myDsint_getvideo_RequestStruct_SOAPSerializer;
    private static final javax.xml.namespace.QName ns1_getvideo_getvideoResponse_QNAME = new QName("urn:ds", "getvideoResponse");
    private static final javax.xml.namespace.QName ns1_getvideoResponse_TYPE_QNAME = new QName("urn:ds", "getvideoResponse");
    private CombinedSerializer ns1_myDsint_getvideo_ResponseStruct_SOAPSerializer;
    private static final java.lang.String[] myNamespace_declarations =
                                        new java.lang.String[] {
                                            "ns0", "urn:ds"
                                        };
    
    private static final QName[] understoodHeaderNames = new QName[] {  };
}
