// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: EmployeeService.proto

package EmployeeService;

public final class EmployeeServiceProto {
  private EmployeeServiceProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_EmployeeService_AddEmployeeRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_EmployeeService_AddEmployeeRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_EmployeeService_AddEmployeeResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_EmployeeService_AddEmployeeResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_EmployeeService_GetEmployeeRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_EmployeeService_GetEmployeeRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_EmployeeService_GetEmployeeResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_EmployeeService_GetEmployeeResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_EmployeeService_UpdateEmployeeRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_EmployeeService_UpdateEmployeeRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_EmployeeService_UpdateEmployeeResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_EmployeeService_UpdateEmployeeResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_EmployeeService_Employee_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_EmployeeService_Employee_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\025EmployeeService.proto\022\017EmployeeService" +
      "\"O\n\022AddEmployeeRequest\022\n\n\002id\030\001 \001(\005\022\014\n\004na" +
      "me\030\002 \001(\t\022\013\n\003age\030\003 \001(\005\022\022\n\ndepartment\030\004 \001(" +
      "\t\"!\n\023AddEmployeeResponse\022\n\n\002id\030\001 \001(\005\" \n\022" +
      "GetEmployeeRequest\022\n\n\002id\030\001 \001(\005\"P\n\023GetEmp" +
      "loyeeResponse\022\n\n\002id\030\001 \001(\005\022\014\n\004name\030\002 \001(\t\022" +
      "\013\n\003age\030\003 \001(\005\022\022\n\ndepartment\030\004 \001(\t\"P\n\025Upda" +
      "teEmployeeRequest\022\n\n\002id\030\001 \001(\005\022+\n\010employe" +
      "e\030\002 \001(\0132\031.EmployeeService.Employee\")\n\026Up" +
      "dateEmployeeResponse\022\017\n\007success\030\001 \001(\010\"E\n",
      "\010Employee\022\n\n\002id\030\001 \001(\005\022\014\n\004name\030\002 \001(\t\022\013\n\003a" +
      "ge\030\003 \001(\005\022\022\n\ndepartment\030\004 \001(\t2\262\002\n\017Employe" +
      "eService\022Z\n\013AddEmployee\022#.EmployeeServic" +
      "e.AddEmployeeRequest\032$.EmployeeService.A" +
      "ddEmployeeResponse\"\000\022Z\n\013GetEmployee\022#.Em" +
      "ployeeService.GetEmployeeRequest\032$.Emplo" +
      "yeeService.GetEmployeeResponse\"\000\022g\n\016Upda" +
      "teEmployee\022&.EmployeeService.UpdateEmplo" +
      "yeeRequest\032\'.EmployeeService.UpdateEmplo" +
      "yeeResponse\"\000(\0010\001B)\n\017EmployeeServiceB\024Em",
      "ployeeServiceProtoP\001b\006proto3"
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
    internal_static_EmployeeService_AddEmployeeRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_EmployeeService_AddEmployeeRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_EmployeeService_AddEmployeeRequest_descriptor,
        new String[] { "Id", "Name", "Age", "Department", });
    internal_static_EmployeeService_AddEmployeeResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_EmployeeService_AddEmployeeResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_EmployeeService_AddEmployeeResponse_descriptor,
        new String[] { "Id", });
    internal_static_EmployeeService_GetEmployeeRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_EmployeeService_GetEmployeeRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_EmployeeService_GetEmployeeRequest_descriptor,
        new String[] { "Id", });
    internal_static_EmployeeService_GetEmployeeResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_EmployeeService_GetEmployeeResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_EmployeeService_GetEmployeeResponse_descriptor,
        new String[] { "Id", "Name", "Age", "Department", });
    internal_static_EmployeeService_UpdateEmployeeRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_EmployeeService_UpdateEmployeeRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_EmployeeService_UpdateEmployeeRequest_descriptor,
        new String[] { "Id", "Employee", });
    internal_static_EmployeeService_UpdateEmployeeResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_EmployeeService_UpdateEmployeeResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_EmployeeService_UpdateEmployeeResponse_descriptor,
        new String[] { "Success", });
    internal_static_EmployeeService_Employee_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_EmployeeService_Employee_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_EmployeeService_Employee_descriptor,
        new String[] { "Id", "Name", "Age", "Department", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
