// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: bank-service.proto

package com.bank.models;

public final class BankServiceOuterClass {
  private BankServiceOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_BalanceCheckRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_BalanceCheckRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Balance_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Balance_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_WithdrawRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_WithdrawRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Money_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Money_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_DepositRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_DepositRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022bank-service.proto\"-\n\023BalanceCheckRequ" +
      "est\022\026\n\016account_number\030\001 \001(\005\"\031\n\007Balance\022\016" +
      "\n\006amount\030\001 \001(\005\"9\n\017WithdrawRequest\022\026\n\016acc" +
      "ount_number\030\001 \001(\005\022\016\n\006amount\030\002 \001(\005\"\026\n\005Mon" +
      "ey\022\r\n\005value\030\001 \001(\005\"8\n\016DepositRequest\022\026\n\016a" +
      "ccount_number\030\001 \001(\005\022\016\n\006amount\030\002 \001(\0052\213\001\n\013" +
      "BankService\022,\n\ngetBalance\022\024.BalanceCheck" +
      "Request\032\010.Balance\022&\n\010withdraw\022\020.Withdraw" +
      "Request\032\006.Money0\001\022&\n\007deposit\022\017.DepositRe" +
      "quest\032\010.Balance(\001B\023\n\017com.bank.modelsP\001b\006" +
      "proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_BalanceCheckRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_BalanceCheckRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_BalanceCheckRequest_descriptor,
        new java.lang.String[] { "AccountNumber", });
    internal_static_Balance_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Balance_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Balance_descriptor,
        new java.lang.String[] { "Amount", });
    internal_static_WithdrawRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_WithdrawRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_WithdrawRequest_descriptor,
        new java.lang.String[] { "AccountNumber", "Amount", });
    internal_static_Money_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_Money_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Money_descriptor,
        new java.lang.String[] { "Value", });
    internal_static_DepositRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_DepositRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_DepositRequest_descriptor,
        new java.lang.String[] { "AccountNumber", "Amount", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
