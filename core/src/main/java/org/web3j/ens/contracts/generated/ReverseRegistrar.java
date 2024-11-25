package org.web3j.ens.contracts.generated;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
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
 * <a href="https://github.com/hyperledger/web3j/tree/main/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.12.2.
 */
@SuppressWarnings("rawtypes")
public class ReverseRegistrar extends Contract {
    public static final String BINARY = "60a060405234801561000f575f80fd5b50604051610e27380380610e2783398101604081905261002e916101ab565b61003733610145565b6001600160a01b03811660808190526040516302571be360e01b81527f91d1777781884d03a6757a803996e38de2a42967fb37eeaca72729271025a9e260048201525f91906302571be390602401602060405180830381865afa1580156100a0573d5f803e3d5ffd5b505050506040513d601f19601f820116820180604052508101906100c491906101ab565b90506001600160a01b0381161561013e57604051630f41a04d60e11b81523360048201526001600160a01b03821690631e83409a906024016020604051808303815f875af1158015610118573d5f803e3d5ffd5b505050506040513d601f19601f8201168201806040525081019061013c91906101cd565b505b50506101e4565b5f80546001600160a01b038381166001600160a01b0319831681178455604051919092169283917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e09190a35050565b6001600160a01b03811681146101a8575f80fd5b50565b5f602082840312156101bb575f80fd5b81516101c681610194565b9392505050565b5f602082840312156101dd575f80fd5b5051919050565b608051610c1d61020a5f395f8181610127015281816102cb01526104c40152610c1d5ff3fe608060405234801561000f575f80fd5b50600436106100e5575f3560e01c80638da5cb5b11610088578063c66485b211610063578063c66485b2146101da578063da8c229e146101ed578063e0dba60f1461021f578063f2fde38b14610232575f80fd5b80638da5cb5b146101a4578063bffbe61c146101b4578063c47f0027146101c7575f80fd5b806365669631116100c35780636566963114610161578063715018a6146101745780637a806d6b1461017e578063828eab0e14610191575f80fd5b80630f5a5466146100e95780631e83409a1461010f5780633f15457f14610122575b5f80fd5b6100fc6100f7366004610958565b610245565b6040519081526020015b60405180910390f35b6100fc61011d36600461098f565b610258565b6101497f000000000000000000000000000000000000000000000000000000000000000081565b6040516001600160a01b039091168152602001610106565b6100fc61016f3660046109aa565b610279565b61017c610526565b005b6100fc61018c366004610a91565b610539565b600254610149906001600160a01b031681565b5f546001600160a01b0316610149565b6100fc6101c236600461098f565b6105ae565b6100fc6101d5366004610b02565b610608565b61017c6101e836600461098f565b610624565b61020f6101fb36600461098f565b60016020525f908152604090205460ff1681565b6040519015158152602001610106565b61017c61022d366004610b49565b6106e4565b61017c61024036600461098f565b61074a565b5f610251338484610279565b9392505050565b6002545f9061027390339084906001600160a01b0316610279565b92915050565b5f836001600160a01b0381163314806102a05750335f9081526001602052604090205460ff165b80610334575060405163e985e9c560e01b81526001600160a01b0382811660048301523360248301527f0000000000000000000000000000000000000000000000000000000000000000169063e985e9c590604401602060405180830381865afa158015610310573d5f803e3d5ffd5b505050506040513d601f19601f820116820180604052508101906103349190610b75565b806103435750610343816107c3565b6103e05760405162461bcd60e51b815260206004820152605b60248201527f526576657273655265676973747261723a2043616c6c6572206973206e6f742060448201527f6120636f6e74726f6c6c6572206f7220617574686f726973656420627920616460648201527f6472657373206f7220746865206164647265737320697473656c660000000000608482015260a4015b60405180910390fd5b5f6103ea8661083a565b604080517f91d1777781884d03a6757a803996e38de2a42967fb37eeaca72729271025a9e2602080830191909152818301849052825180830384018152606090920192839052815191012091925081906001600160a01b038916907f6ada868dd3058cf77a48a74489fd7963688e5464b2b0fa957ace976243270e92905f90a36040516305ef2c7f60e41b81527f91d1777781884d03a6757a803996e38de2a42967fb37eeaca72729271025a9e26004820152602481018390526001600160a01b03878116604483015286811660648301525f60848301527f00000000000000000000000000000000000000000000000000000000000000001690635ef2c7f09060a4015f604051808303815f87803b158015610505575f80fd5b505af1158015610517573d5f803e3d5ffd5b50929998505050505050505050565b61052e61089c565b6105375f6108f5565b565b5f80610546868686610279565b604051637737221360e01b81529091506001600160a01b038516906377372213906105779084908790600401610b90565b5f604051808303815f87803b15801561058e575f80fd5b505af11580156105a0573d5f803e3d5ffd5b509298975050505050505050565b5f7f91d1777781884d03a6757a803996e38de2a42967fb37eeaca72729271025a9e26105d98361083a565b604080516020810193909352820152606001604051602081830303815290604052805190602001209050919050565b6002545f9061027390339081906001600160a01b031685610539565b61062c61089c565b6001600160a01b03811661069b5760405162461bcd60e51b815260206004820152603060248201527f526576657273655265676973747261723a205265736f6c76657220616464726560448201526f07373206d757374206e6f7420626520360841b60648201526084016103d7565b600280546001600160a01b0319166001600160a01b0383169081179091556040517feae17a84d9eb83d8c8eb317f9e7d64857bc363fa51674d996c023f4340c577cf905f90a250565b6106ec61089c565b6001600160a01b0382165f81815260016020908152604091829020805460ff191685151590811790915591519182527f4c97694570a07277810af7e5669ffd5f6a2d6b74b6e9a274b8b870fd5114cf87910160405180910390a25050565b61075261089c565b6001600160a01b0381166107b75760405162461bcd60e51b815260206004820152602660248201527f4f776e61626c653a206e6577206f776e657220697320746865207a65726f206160448201526564647265737360d01b60648201526084016103d7565b6107c0816108f5565b50565b5f816001600160a01b0316638da5cb5b6040518163ffffffff1660e01b8152600401602060405180830381865afa92505050801561081e575060408051601f3d908101601f1916820190925261081b91810190610bcc565b60015b61082957505f919050565b6001600160a01b0316331492915050565b5f60285b8015610891575f19016f181899199a1a9b1b9c1cb0b131b232b360811b600f84161a81536010909204915f19016f181899199a1a9b1b9c1cb0b131b232b360811b600f84161a815360108304925061083e565b505060285f20919050565b5f546001600160a01b031633146105375760405162461bcd60e51b815260206004820181905260248201527f4f776e61626c653a2063616c6c6572206973206e6f7420746865206f776e657260448201526064016103d7565b5f80546001600160a01b038381166001600160a01b0319831681178455604051919092169283917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e09190a35050565b6001600160a01b03811681146107c0575f80fd5b5f8060408385031215610969575f80fd5b823561097481610944565b9150602083013561098481610944565b809150509250929050565b5f6020828403121561099f575f80fd5b813561025181610944565b5f805f606084860312156109bc575f80fd5b83356109c781610944565b925060208401356109d781610944565b915060408401356109e781610944565b809150509250925092565b634e487b7160e01b5f52604160045260245ffd5b5f82601f830112610a15575f80fd5b813567ffffffffffffffff811115610a2f57610a2f6109f2565b604051601f8201601f19908116603f0116810167ffffffffffffffff81118282101715610a5e57610a5e6109f2565b604052818152838201602001851015610a75575f80fd5b816020850160208301375f918101602001919091529392505050565b5f805f8060808587031215610aa4575f80fd5b8435610aaf81610944565b93506020850135610abf81610944565b92506040850135610acf81610944565b9150606085013567ffffffffffffffff811115610aea575f80fd5b610af687828801610a06565b91505092959194509250565b5f60208284031215610b12575f80fd5b813567ffffffffffffffff811115610b28575f80fd5b610b3484828501610a06565b949350505050565b80151581146107c0575f80fd5b5f8060408385031215610b5a575f80fd5b8235610b6581610944565b9150602083013561098481610b3c565b5f60208284031215610b85575f80fd5b815161025181610b3c565b828152604060208201525f82518060408401528060208501606085015e5f606082850101526060601f19601f8301168401019150509392505050565b5f60208284031215610bdc575f80fd5b81516102518161094456fea2646970667358221220c370a6c9398b82bdee5c1487b08a61e11feefc977b7701fd97121b9b92b9c81164736f6c634300081a0033";

    private static String librariesLinkedBinary;

    public static final String FUNC_CLAIM = "claim";

    public static final String FUNC_CLAIMFORADDR = "claimForAddr";

    public static final String FUNC_CLAIMWITHRESOLVER = "claimWithResolver";

    public static final String FUNC_CONTROLLERS = "controllers";

    public static final String FUNC_DEFAULTRESOLVER = "defaultResolver";

    public static final String FUNC_ENS = "ens";

    public static final String FUNC_NODE = "node";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_RENOUNCEOWNERSHIP = "renounceOwnership";

    public static final String FUNC_SETCONTROLLER = "setController";

    public static final String FUNC_SETDEFAULTRESOLVER = "setDefaultResolver";

    public static final String FUNC_SETNAME = "setName";

    public static final String FUNC_SETNAMEFORADDR = "setNameForAddr";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final Event CONTROLLERCHANGED_EVENT = new Event("ControllerChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Bool>() {}));
    ;

    public static final Event DEFAULTRESOLVERCHANGED_EVENT = new Event("DefaultResolverChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event REVERSECLAIMED_EVENT = new Event("ReverseClaimed", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Bytes32>(true) {}));
    ;

    @Deprecated
    protected ReverseRegistrar(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ReverseRegistrar(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ReverseRegistrar(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ReverseRegistrar(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<ControllerChangedEventResponse> getControllerChangedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(CONTROLLERCHANGED_EVENT, transactionReceipt);
        ArrayList<ControllerChangedEventResponse> responses = new ArrayList<ControllerChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ControllerChangedEventResponse typedResponse = new ControllerChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.controller = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.enabled = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static ControllerChangedEventResponse getControllerChangedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(CONTROLLERCHANGED_EVENT, log);
        ControllerChangedEventResponse typedResponse = new ControllerChangedEventResponse();
        typedResponse.log = log;
        typedResponse.controller = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.enabled = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<ControllerChangedEventResponse> controllerChangedEventFlowable(
            EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getControllerChangedEventFromLog(log));
    }

    public Flowable<ControllerChangedEventResponse> controllerChangedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CONTROLLERCHANGED_EVENT));
        return controllerChangedEventFlowable(filter);
    }

    public static List<DefaultResolverChangedEventResponse> getDefaultResolverChangedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(DEFAULTRESOLVERCHANGED_EVENT, transactionReceipt);
        ArrayList<DefaultResolverChangedEventResponse> responses = new ArrayList<DefaultResolverChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DefaultResolverChangedEventResponse typedResponse = new DefaultResolverChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.resolver = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static DefaultResolverChangedEventResponse getDefaultResolverChangedEventFromLog(
            Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(DEFAULTRESOLVERCHANGED_EVENT, log);
        DefaultResolverChangedEventResponse typedResponse = new DefaultResolverChangedEventResponse();
        typedResponse.log = log;
        typedResponse.resolver = (String) eventValues.getIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<DefaultResolverChangedEventResponse> defaultResolverChangedEventFlowable(
            EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getDefaultResolverChangedEventFromLog(log));
    }

    public Flowable<DefaultResolverChangedEventResponse> defaultResolverChangedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DEFAULTRESOLVERCHANGED_EVENT));
        return defaultResolverChangedEventFlowable(filter);
    }

    public static List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static OwnershipTransferredEventResponse getOwnershipTransferredEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, log);
        OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
        typedResponse.log = log;
        typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
        return typedResponse;
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(
            EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getOwnershipTransferredEventFromLog(log));
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPTRANSFERRED_EVENT));
        return ownershipTransferredEventFlowable(filter);
    }

    public static List<ReverseClaimedEventResponse> getReverseClaimedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(REVERSECLAIMED_EVENT, transactionReceipt);
        ArrayList<ReverseClaimedEventResponse> responses = new ArrayList<ReverseClaimedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ReverseClaimedEventResponse typedResponse = new ReverseClaimedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.addr = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.node = (byte[]) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static ReverseClaimedEventResponse getReverseClaimedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(REVERSECLAIMED_EVENT, log);
        ReverseClaimedEventResponse typedResponse = new ReverseClaimedEventResponse();
        typedResponse.log = log;
        typedResponse.addr = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.node = (byte[]) eventValues.getIndexedValues().get(1).getValue();
        return typedResponse;
    }

    public Flowable<ReverseClaimedEventResponse> reverseClaimedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getReverseClaimedEventFromLog(log));
    }

    public Flowable<ReverseClaimedEventResponse> reverseClaimedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(REVERSECLAIMED_EVENT));
        return reverseClaimedEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> claim(String owner) {
        final Function function = new Function(
                FUNC_CLAIM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> claimForAddr(String addr, String owner,
            String resolver) {
        final Function function = new Function(
                FUNC_CLAIMFORADDR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, addr), 
                new org.web3j.abi.datatypes.Address(160, owner), 
                new org.web3j.abi.datatypes.Address(160, resolver)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> claimWithResolver(String owner, String resolver) {
        final Function function = new Function(
                FUNC_CLAIMWITHRESOLVER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner), 
                new org.web3j.abi.datatypes.Address(160, resolver)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> controllers(String param0) {
        final Function function = new Function(FUNC_CONTROLLERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> defaultResolver() {
        final Function function = new Function(FUNC_DEFAULTRESOLVER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> ens() {
        final Function function = new Function(FUNC_ENS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<byte[]> node(String addr) {
        final Function function = new Function(FUNC_NODE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, addr)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> renounceOwnership() {
        final Function function = new Function(
                FUNC_RENOUNCEOWNERSHIP, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setController(String controller,
            Boolean enabled) {
        final Function function = new Function(
                FUNC_SETCONTROLLER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, controller), 
                new org.web3j.abi.datatypes.Bool(enabled)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setDefaultResolver(String resolver) {
        final Function function = new Function(
                FUNC_SETDEFAULTRESOLVER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, resolver)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setName(String name) {
        final Function function = new Function(
                FUNC_SETNAME, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setNameForAddr(String addr, String owner,
            String resolver, String name) {
        final Function function = new Function(
                FUNC_SETNAMEFORADDR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, addr), 
                new org.web3j.abi.datatypes.Address(160, owner), 
                new org.web3j.abi.datatypes.Address(160, resolver), 
                new org.web3j.abi.datatypes.Utf8String(name)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferOwnership(String newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ReverseRegistrar load(String contractAddress, Web3j web3j,
            Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ReverseRegistrar(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ReverseRegistrar load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ReverseRegistrar(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ReverseRegistrar load(String contractAddress, Web3j web3j,
            Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ReverseRegistrar(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ReverseRegistrar load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ReverseRegistrar(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ReverseRegistrar> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider, String ensAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, ensAddr)));
        return deployRemoteCall(ReverseRegistrar.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    public static RemoteCall<ReverseRegistrar> deploy(Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider,
            String ensAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, ensAddr)));
        return deployRemoteCall(ReverseRegistrar.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ReverseRegistrar> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit, String ensAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, ensAddr)));
        return deployRemoteCall(ReverseRegistrar.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ReverseRegistrar> deploy(Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit,
            String ensAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, ensAddr)));
        return deployRemoteCall(ReverseRegistrar.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
    }

    public static void linkLibraries(List<Contract.LinkReference> references) {
        librariesLinkedBinary = linkBinaryWithReferences(BINARY, references);
    }

    private static String getDeploymentBinary() {
        if (librariesLinkedBinary != null) {
            return librariesLinkedBinary;
        } else {
            return BINARY;
        }
    }

    public static class ControllerChangedEventResponse extends BaseEventResponse {
        public String controller;

        public Boolean enabled;
    }

    public static class DefaultResolverChangedEventResponse extends BaseEventResponse {
        public String resolver;
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }

    public static class ReverseClaimedEventResponse extends BaseEventResponse {
        public String addr;

        public byte[] node;
    }
}
