// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: elide/base/language.proto

package tools.elide.base;

public final class BaseLanguage {
  private BaseLanguage() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_base_LanguageSpec_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_base_LanguageSpec_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\031elide/base/language.proto\022\004base\"\215\001\n\014La" +
      "nguageSpec\022\"\n\010language\030\001 \001(\0162\016.base.Lang" +
      "uageH\000\022\026\n\014iso_language\030\002 \001(\tH\000\022\025\n\013iso_co" +
      "untry\030\003 \001(\tH\001\022\021\n\007dialect\030\004 \001(\tH\001B\013\n\tsele" +
      "ctionB\n\n\010modifier*j\n\010Language\022\013\n\007ENGLISH" +
      "\020\000\022\n\n\006FRENCH\020\001\022\013\n\007SPANISH\020\002\022\013\n\007CHINESE\020\003" +
      "\022\024\n\020CHINESE_MANDARIN\020\004\022\025\n\021CHINESE_CANTON" +
      "ESE\020\005B\204\001\n\020tools.elide.baseB\014BaseLanguage" +
      "H\001P\001Z!github.com/elide-tools/elide/base\330" +
      "\001\001\370\001\001\242\002\003ELD\252\002\nElide.Base\272\002\005Elide\302\002\003ELD\312\002" +
      "\005Elide\352\002\013Elide::Baseb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_base_LanguageSpec_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_base_LanguageSpec_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_base_LanguageSpec_descriptor,
        new java.lang.String[] { "Language", "IsoLanguage", "IsoCountry", "Dialect", "Selection", "Modifier", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}