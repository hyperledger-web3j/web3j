package org.web3j.generated;


import io.reactivex.Flowable;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicStruct;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version none.
 */
@SuppressWarnings("rawtypes")
public class ComplexStorage extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50610916806100206000396000f3006080604052600436106100615763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663243dc8da81146100665780632cf0739514610091578063c2256513146100b3578063cfd91f2b146100d3575b600080fd5b34801561007257600080fd5b5061007b6100f6565b6040516100889190610811565b60405180910390f35b34801561009d57600080fd5b506100b16100ac366004610728565b610241565b005b3480156100bf57600080fd5b506100b16100ce3660046106eb565b61027a565b3480156100df57600080fd5b506100e86102a5565b604051610088929190610822565b6100fe6104f5565b604080516000805460606020601f6002600019610100600187161502019094169390930492830181900402840181018552938301818152929391928492909184918401828280156101905780601f1061016557610100808354040283529160200191610190565b820191906000526020600020905b81548152906001019060200180831161017357829003601f168201915b50505050508152602001600182018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156102325780601f1061020757610100808354040283529160200191610232565b820191906000526020600020905b81548152906001019060200180831161021557829003601f168201915b50505050508152505090505b90565b80518051829160009161025b91839160209091019061050c565b506020828101518051610274926001850192019061050c565b50505050565b80518051829160029161029491839160209091019061050c565b506020820151816001015590505050565b6102ad6104f5565b6102b561058a565b3373ffffffffffffffffffffffffffffffffffffffff167fed780f1dfaf928f77dd066a615b98641a01d34bf8b139c6f87ae25365fdc9a1f83836040516102fd929190610822565b60405180910390a260408051600080546020600260018316156101000260001901909216829004601f810182900490910284016060908101865294840181815292949193928592849284918401828280156103995780601f1061036e57610100808354040283529160200191610399565b820191906000526020600020905b81548152906001019060200180831161037c57829003601f168201915b50505050508152602001600182018054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561043b5780601f106104105761010080835404028352916020019161043b565b820191906000526020600020905b81548152906001019060200180831161041e57829003601f168201915b50505091909252505060408051845460606020601f600260001961010060018716150201909416939093049283018190040283018101845292820181815294965090938593508492909184918401828280156104d85780601f106104ad576101008083540402835291602001916104d8565b820191906000526020600020905b8154815290600101906020018083116104bb57829003601f168201915b505050505081526020016001820154815250509050915091509091565b604080518082019091526060808252602082015290565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061054d57805160ff191683800117855561057a565b8280016001018555821561057a579182015b8281111561057a57825182559160200191906001019061055f565b506105869291506105a2565b5090565b60408051808201909152606081526000602082015290565b61023e91905b8082111561058657600081556001016105a8565b6000601f820183136105cd57600080fd5b81356105e06105db8261086e565b610847565b915080825260208301602083018583830111156105fc57600080fd5b61060783828461089a565b50505092915050565b60006040828403121561062257600080fd5b61062c6040610847565b9050813567ffffffffffffffff81111561064557600080fd5b610651848285016105bc565b8252506020610662848483016106d8565b60208301525092915050565b60006040828403121561068057600080fd5b61068a6040610847565b9050813567ffffffffffffffff8111156106a357600080fd5b6106af848285016105bc565b825250602082013567ffffffffffffffff8111156106cc57600080fd5b610662848285016105bc565b60006106e4823561023e565b9392505050565b6000602082840312156106fd57600080fd5b813567ffffffffffffffff81111561071457600080fd5b61072084828501610610565b949350505050565b60006020828403121561073a57600080fd5b813567ffffffffffffffff81111561075157600080fd5b6107208482850161066e565b600061076882610896565b80845261077c8160208601602086016108a6565b610785816108d2565b9093016020019392505050565b80516040808452600091908401906107aa828261075d565b91505060208301516107bf6020860182610802565b509392505050565b80516040808452600091908401906107df828261075d565b915050602083015184820360208601526107f9828261075d565b95945050505050565b61080b8161023e565b82525050565b602080825281016106e481846107c7565b6040808252810161083381856107c7565b905081810360208301526107208184610792565b60405181810167ffffffffffffffff8111828210171561086657600080fd5b604052919050565b600067ffffffffffffffff82111561088557600080fd5b506020601f91909101601f19160190565b5190565b82818337506000910152565b60005b838110156108c15781810151838201526020016108a9565b838111156102745750506000910152565b601f01601f1916905600a265627a7a723058207cab802cd54ff404f031f15d561bbe370b5f50c0656b4fe3058297dfc4501d096c6578706572696d656e74616cf50037";

    public static final String FUNC_GETFOO = "getFoo";

    public static final String FUNC_SETFOO = "setFoo";

    public static final String FUNC_SETBAR = "setBar";

    public static final String FUNC_GETFOOBAR = "getFooBar";

    public static final Event ACCESS_EVENT = new Event("Access",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<ComplexStorage.TupleClass1>() {}, new TypeReference<ComplexStorage.TupleClass2>() {}));
    ;

    @Deprecated
    protected ComplexStorage(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ComplexStorage(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ComplexStorage(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ComplexStorage(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<ComplexStorage.TupleClass1> getFoo() {
        final Function function = new Function(FUNC_GETFOO,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<ComplexStorage.TupleClass1>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setFoo(ComplexStorage.TupleClass1 _toSet) {
        final Function function = new Function(
                FUNC_SETFOO,
                Arrays.<Type>asList(_toSet),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setBar(ComplexStorage.TupleClass2 _toSet) {
        final Function function = new Function(
                FUNC_SETBAR,
                Arrays.<Type>asList(_toSet),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> getFooBar() {
        final Function function = new Function(
                FUNC_GETFOOBAR,
                Arrays.<Type>asList(),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<AccessEventResponse> getAccessEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ACCESS_EVENT, transactionReceipt);
        ArrayList<AccessEventResponse> responses = new ArrayList<AccessEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AccessEventResponse typedResponse = new AccessEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._address = (Address) eventValues.getIndexedValues().get(0);
            typedResponse._foo = (ComplexStorage.TupleClass1) eventValues.getNonIndexedValues().get(0);
            typedResponse._bar = (ComplexStorage.TupleClass2) eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AccessEventResponse> accessEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, AccessEventResponse>() {
            @Override
            public AccessEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ACCESS_EVENT, log);
                AccessEventResponse typedResponse = new AccessEventResponse();
                typedResponse.log = log;
                typedResponse._address = (Address) eventValues.getIndexedValues().get(0);
                typedResponse._foo = (ComplexStorage.TupleClass1) eventValues.getNonIndexedValues().get(0);
                typedResponse._bar = (ComplexStorage.TupleClass2) eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public Flowable<AccessEventResponse> accessEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ACCESS_EVENT));
        return accessEventFlowable(filter);
    }

    @Deprecated
    public static ComplexStorage load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ComplexStorage(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ComplexStorage load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ComplexStorage(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ComplexStorage load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ComplexStorage(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ComplexStorage load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ComplexStorage(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ComplexStorage> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ComplexStorage.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ComplexStorage> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ComplexStorage.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ComplexStorage> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ComplexStorage.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ComplexStorage> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ComplexStorage.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class TupleClass1 extends DynamicStruct {
        public String id;

        public String name;

        public TupleClass1(String id, String name) {
            super(new org.web3j.abi.datatypes.Utf8String(id), new org.web3j.abi.datatypes.Utf8String(name));
            this.id = id;
            this.name = name;
        }
    }

    public static class TupleClass2 extends DynamicStruct {
        public String id;

        public BigInteger data;

        public TupleClass2(String id, BigInteger data) {
            super(new org.web3j.abi.datatypes.Utf8String(id), new org.web3j.abi.datatypes.generated.Uint256(data));
            this.id = id;
            this.data = data;
        }
    }

    public static class AccessEventResponse extends BaseEventResponse {
        public Address _address;

        public ComplexStorage.TupleClass1 _foo;

        public ComplexStorage.TupleClass2 _bar;
    }
}