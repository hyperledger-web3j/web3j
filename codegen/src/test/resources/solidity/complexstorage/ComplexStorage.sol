//in order for experimental ABIEncoderV2 to be “stable” when passing structs as arguments we must
//use at least version 0.4.19 of solidity
pragma solidity ^0.4.19;
pragma experimental ABIEncoderV2;

contract ComplexStorage {

    struct Foo {
        string id;
        string name;
    }

    struct Bar {
        string id;
        uint data;
    }

    Foo foo;
    Bar bar;

    function setFoo(Foo _toSet) public {
        foo = _toSet;
    }

    function setBar(Bar _toSet) public {
        bar = _toSet;
    }

    function getFoo() constant public returns (Foo) {
        return foo;
    }

    function getFooBar() public returns (Foo _foo, Bar _bar) {
        emit Access(msg.sender, _foo, _bar);
        return (foo, bar);
    }

    event Access(address indexed _address, Foo _foo, Bar _bar);
}