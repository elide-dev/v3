// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: elide/page/semantic.proto

package tools.elide.page;

public final class WebSemantics {
  private WebSemantics() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_page_SemanticMetadata_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_page_SemanticMetadata_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\031elide/page/semantic.proto\022\004page\032\026elide" +
      "/page/media.proto\"\211\001\n\020SemanticMetadata\022\030" +
      "\n\004kind\030\001 \001(\0162\n.page.Kind\022\034\n\006format\030\002 \003(\016" +
      "2\014.page.Format\022\037\n\005media\030\003 \003(\0132\020.page.Med" +
      "iaAsset\022\021\n\007content\030\004 \001(\tH\000B\t\n\007payload*,\n" +
      "\004Kind\022\014\n\010WEB_PAGE\020\000\022\n\n\006MASTER\020\001\022\n\n\006DETAI" +
      "L\020\002*1\n\006Format\022\013\n\007GENERIC\020\000\022\r\n\tOPENGRAPH\020" +
      "\001\022\013\n\007JSON_LD\020\002B\204\001\n\020tools.elide.pageB\014Web" +
      "SemanticsH\001P\001Z!github.com/elide-tools/el" +
      "ide/page\330\001\001\370\001\001\242\002\003ELD\252\002\nElide.Page\272\002\005Elid" +
      "e\302\002\003ELD\312\002\005Elide\352\002\013Elide::Pageb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          tools.elide.page.WebMedia.getDescriptor(),
        });
    internal_static_page_SemanticMetadata_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_page_SemanticMetadata_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_page_SemanticMetadata_descriptor,
        new java.lang.String[] { "Kind", "Format", "Media", "Content", "Payload", });
    tools.elide.page.WebMedia.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
