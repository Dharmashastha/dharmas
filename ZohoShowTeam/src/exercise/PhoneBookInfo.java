// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PhoneInfo.proto

package exercise;

public final class PhoneBookInfo {
  private PhoneBookInfo() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Phone_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Phone_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_PhoneBook_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PhoneBook_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017PhoneInfo.proto\";\n\005Phone\022\014\n\004name\030\001 \001(\t" +
      "\022\023\n\013phoneNumber\030\002 \001(\003\022\017\n\007address\030\003 \001(\t\"&" +
      "\n\tPhoneBook\022\031\n\tphoneInfo\030\001 \003(\0132\006.PhoneB\033" +
      "\n\010exerciseB\rPhoneBookInfoP\001"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_Phone_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Phone_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Phone_descriptor,
        new java.lang.String[] { "Name", "PhoneNumber", "Address", });
    internal_static_PhoneBook_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_PhoneBook_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_PhoneBook_descriptor,
        new java.lang.String[] { "PhoneInfo", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
