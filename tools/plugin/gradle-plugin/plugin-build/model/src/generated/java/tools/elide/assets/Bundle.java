// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: elide/assets/bundle.proto

package tools.elide.assets;

public final class Bundle {
  private Bundle() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_assets_AssetBundle_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_assets_AssetBundle_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_assets_AssetBundle_DigestSettings_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_assets_AssetBundle_DigestSettings_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_assets_AssetBundle_RewriteMap_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_assets_AssetBundle_RewriteMap_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_assets_AssetBundle_RewriteMap_MapEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_assets_AssetBundle_RewriteMap_MapEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_assets_AssetBundle_BundlerSettings_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_assets_AssetBundle_BundlerSettings_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_assets_AssetBundle_AssetDependencies_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_assets_AssetBundle_AssetDependencies_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_assets_AssetBundle_StyleBundle_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_assets_AssetBundle_StyleBundle_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_assets_AssetBundle_StyleBundle_StyleAsset_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_assets_AssetBundle_StyleBundle_StyleAsset_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_assets_AssetBundle_ScriptBundle_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_assets_AssetBundle_ScriptBundle_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_assets_AssetBundle_ScriptBundle_ScriptAsset_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_assets_AssetBundle_ScriptBundle_ScriptAsset_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_assets_AssetBundle_GenericBundle_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_assets_AssetBundle_GenericBundle_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_assets_AssetBundle_AssetContent_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_assets_AssetBundle_AssetContent_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_assets_AssetBundle_StylesEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_assets_AssetBundle_StylesEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_assets_AssetBundle_ScriptsEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_assets_AssetBundle_ScriptsEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_assets_AssetBundle_GenericEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_assets_AssetBundle_GenericEntry_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\031elide/assets/bundle.proto\022\006assets\032\037goo" +
      "gle/protobuf/timestamp.proto\032\031elide/cryp" +
      "to/crypto.proto\032\025elide/data/data.proto\032\027" +
      "elide/model/model.proto\032\030elide/struct/bl" +
      "oom.proto\032\025elide/page/page.proto\"\355\017\n\013Ass" +
      "etBundle\022\017\n\007version\030\001 \001(\r\0225\n\010settings\030\002 " +
      "\001(\0132#.assets.AssetBundle.BundlerSettings" +
      "\022-\n\tgenerated\030\003 \001(\0132\032.google.protobuf.Ti" +
      "mestamp\022\016\n\006digest\030\004 \001(\014\022/\n\006styles\030\005 \003(\0132" +
      "\037.assets.AssetBundle.StylesEntry\0221\n\007scri" +
      "pts\030\006 \003(\0132 .assets.AssetBundle.ScriptsEn" +
      "try\0221\n\007generic\030\007 \003(\0132 .assets.AssetBundl" +
      "e.GenericEntry\022/\n\005asset\030\010 \003(\0132 .assets.A" +
      "ssetBundle.AssetContent\032X\n\016DigestSetting" +
      "s\022(\n\talgorithm\030\001 \001(\0162\025.crypto.HashAlgori" +
      "thm\022\014\n\004tail\030\002 \001(\r\022\016\n\006rounds\030\003 \001(\r\032|\n\nRew" +
      "riteMap\022\014\n\004file\030\001 \001(\t\0224\n\003map\030\002 \003(\0132\'.ass" +
      "ets.AssetBundle.RewriteMap.MapEntry\032*\n\010M" +
      "apEntry\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(\t:\0028\001\032" +
      "\256\001\n\017BundlerSettings\022\016\n\006minify\030\001 \001(\010\022\017\n\007p" +
      "repack\030\002 \001(\010\022\021\n\trewriting\030\003 \001(\010\022*\n\013compr" +
      "ession\030\004 \003(\0162\025.data.CompressionMode\022;\n\017d" +
      "igest_settings\030\005 \001(\0132\".assets.AssetBundl" +
      "e.DigestSettings\032Z\n\021AssetDependencies\022\016\n" +
      "\006direct\030\001 \003(\t\022\022\n\ntransitive\030\002 \003(\t\022!\n\004mas" +
      "k\030\003 \001(\0132\023.struct.BloomFilter\032\351\002\n\013StyleBu" +
      "ndle\022\016\n\006module\030\001 \001(\t\0223\n\013rewrite_map\030\002 \001(" +
      "\0132\036.assets.AssetBundle.RewriteMap\022;\n\014dep" +
      "endencies\030\003 \001(\0132%.assets.AssetBundle.Ass" +
      "etDependencies\0229\n\005asset\030\004 \003(\0132*.assets.A" +
      "ssetBundle.StyleBundle.StyleAsset\022\024\n\014com" +
      "pressable\030\005 \001(\010\022\021\n\tcacheable\030\006 \001(\010\032t\n\nSt" +
      "yleAsset\022\r\n\005token\030\001 \001(\t\022\020\n\010filename\030\002 \001(" +
      "\t\0223\n\nstylesheet\030\003 \001(\0132\037.page.Context.Sty" +
      "les.Stylesheet\022\020\n\010renaming\030\004 \001(\010\032\265\002\n\014Scr" +
      "iptBundle\022\016\n\006module\030\001 \001(\t\022;\n\005asset\030\002 \003(\013" +
      "2,.assets.AssetBundle.ScriptBundle.Scrip" +
      "tAsset\022;\n\014dependencies\030\003 \001(\0132%.assets.As" +
      "setBundle.AssetDependencies\022\024\n\014compressa" +
      "ble\030\004 \001(\010\022\021\n\tcacheable\030\005 \001(\010\022\020\n\010external" +
      "\030\006 \001(\010\032`\n\013ScriptAsset\022\r\n\005token\030\001 \001(\t\022\020\n\010" +
      "filename\030\002 \001(\t\0220\n\006script\030\003 \001(\0132 .page.Co" +
      "ntext.Scripts.JavaScript\032\242\001\n\rGenericBund" +
      "le\022\016\n\006module\030\001 \001(\t\022\020\n\010filename\030\002 \001(\t\022\r\n\005" +
      "token\030\003 \001(\t\022%\n\007variant\030\004 \003(\0132\024.data.Comp" +
      "ressedData\022\024\n\014compressable\030\005 \001(\010\022\021\n\tcach" +
      "eable\030\006 \001(\010\022\020\n\010external\030\007 \001(\010\032f\n\014AssetCo" +
      "ntent\022\016\n\006module\030\001 \001(\t\022\020\n\010filename\030\002 \001(\t\022" +
      "\r\n\005token\030\003 \001(\t\022%\n\007variant\030\004 \003(\0132\024.data.C" +
      "ompressedData\032N\n\013StylesEntry\022\013\n\003key\030\001 \001(" +
      "\t\022.\n\005value\030\002 \001(\0132\037.assets.AssetBundle.St" +
      "yleBundle:\0028\001\032P\n\014ScriptsEntry\022\013\n\003key\030\001 \001" +
      "(\t\022/\n\005value\030\002 \001(\0132 .assets.AssetBundle.S" +
      "criptBundle:\0028\001\032Q\n\014GenericEntry\022\013\n\003key\030\001" +
      " \001(\t\0220\n\005value\030\002 \001(\0132!.assets.AssetBundle" +
      ".GenericBundle:\0028\001:\004\200\367\002\004*Q\n\016ManifestForm" +
      "at\022\037\n\033MANIFEST_FORMAT_UNSPECIFIED\020\000\022\n\n\006B" +
      "INARY\020\001\022\010\n\004JSON\020\002\022\010\n\004TEXT\020\003B`\n\022tools.eli" +
      "de.assetsH\001P\001\330\001\001\370\001\001\242\002\003ELD\252\002\014Elide.Assets" +
      "\272\002\005Elide\302\002\003ELD\312\002\014Elide\\Assets\352\002\rElide::A" +
      "ssetsb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.TimestampProto.getDescriptor(),
          tools.elide.crypto.Crypto.getDescriptor(),
          tools.elide.data.Data.getDescriptor(),
          tools.elide.model.Datamodel.getDescriptor(),
          tools.elide.struct.Bloom.getDescriptor(),
          tools.elide.page.WebContext.getDescriptor(),
        });
    internal_static_assets_AssetBundle_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_assets_AssetBundle_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_assets_AssetBundle_descriptor,
        new java.lang.String[] { "Version", "Settings", "Generated", "Digest", "Styles", "Scripts", "Generic", "Asset", });
    internal_static_assets_AssetBundle_DigestSettings_descriptor =
      internal_static_assets_AssetBundle_descriptor.getNestedTypes().get(0);
    internal_static_assets_AssetBundle_DigestSettings_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_assets_AssetBundle_DigestSettings_descriptor,
        new java.lang.String[] { "Algorithm", "Tail", "Rounds", });
    internal_static_assets_AssetBundle_RewriteMap_descriptor =
      internal_static_assets_AssetBundle_descriptor.getNestedTypes().get(1);
    internal_static_assets_AssetBundle_RewriteMap_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_assets_AssetBundle_RewriteMap_descriptor,
        new java.lang.String[] { "File", "Map", });
    internal_static_assets_AssetBundle_RewriteMap_MapEntry_descriptor =
      internal_static_assets_AssetBundle_RewriteMap_descriptor.getNestedTypes().get(0);
    internal_static_assets_AssetBundle_RewriteMap_MapEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_assets_AssetBundle_RewriteMap_MapEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_assets_AssetBundle_BundlerSettings_descriptor =
      internal_static_assets_AssetBundle_descriptor.getNestedTypes().get(2);
    internal_static_assets_AssetBundle_BundlerSettings_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_assets_AssetBundle_BundlerSettings_descriptor,
        new java.lang.String[] { "Minify", "Prepack", "Rewriting", "Compression", "DigestSettings", });
    internal_static_assets_AssetBundle_AssetDependencies_descriptor =
      internal_static_assets_AssetBundle_descriptor.getNestedTypes().get(3);
    internal_static_assets_AssetBundle_AssetDependencies_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_assets_AssetBundle_AssetDependencies_descriptor,
        new java.lang.String[] { "Direct", "Transitive", "Mask", });
    internal_static_assets_AssetBundle_StyleBundle_descriptor =
      internal_static_assets_AssetBundle_descriptor.getNestedTypes().get(4);
    internal_static_assets_AssetBundle_StyleBundle_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_assets_AssetBundle_StyleBundle_descriptor,
        new java.lang.String[] { "Module", "RewriteMap", "Dependencies", "Asset", "Compressable", "Cacheable", });
    internal_static_assets_AssetBundle_StyleBundle_StyleAsset_descriptor =
      internal_static_assets_AssetBundle_StyleBundle_descriptor.getNestedTypes().get(0);
    internal_static_assets_AssetBundle_StyleBundle_StyleAsset_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_assets_AssetBundle_StyleBundle_StyleAsset_descriptor,
        new java.lang.String[] { "Token", "Filename", "Stylesheet", "Renaming", });
    internal_static_assets_AssetBundle_ScriptBundle_descriptor =
      internal_static_assets_AssetBundle_descriptor.getNestedTypes().get(5);
    internal_static_assets_AssetBundle_ScriptBundle_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_assets_AssetBundle_ScriptBundle_descriptor,
        new java.lang.String[] { "Module", "Asset", "Dependencies", "Compressable", "Cacheable", "External", });
    internal_static_assets_AssetBundle_ScriptBundle_ScriptAsset_descriptor =
      internal_static_assets_AssetBundle_ScriptBundle_descriptor.getNestedTypes().get(0);
    internal_static_assets_AssetBundle_ScriptBundle_ScriptAsset_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_assets_AssetBundle_ScriptBundle_ScriptAsset_descriptor,
        new java.lang.String[] { "Token", "Filename", "Script", });
    internal_static_assets_AssetBundle_GenericBundle_descriptor =
      internal_static_assets_AssetBundle_descriptor.getNestedTypes().get(6);
    internal_static_assets_AssetBundle_GenericBundle_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_assets_AssetBundle_GenericBundle_descriptor,
        new java.lang.String[] { "Module", "Filename", "Token", "Variant", "Compressable", "Cacheable", "External", });
    internal_static_assets_AssetBundle_AssetContent_descriptor =
      internal_static_assets_AssetBundle_descriptor.getNestedTypes().get(7);
    internal_static_assets_AssetBundle_AssetContent_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_assets_AssetBundle_AssetContent_descriptor,
        new java.lang.String[] { "Module", "Filename", "Token", "Variant", });
    internal_static_assets_AssetBundle_StylesEntry_descriptor =
      internal_static_assets_AssetBundle_descriptor.getNestedTypes().get(8);
    internal_static_assets_AssetBundle_StylesEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_assets_AssetBundle_StylesEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_assets_AssetBundle_ScriptsEntry_descriptor =
      internal_static_assets_AssetBundle_descriptor.getNestedTypes().get(9);
    internal_static_assets_AssetBundle_ScriptsEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_assets_AssetBundle_ScriptsEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_assets_AssetBundle_GenericEntry_descriptor =
      internal_static_assets_AssetBundle_descriptor.getNestedTypes().get(10);
    internal_static_assets_AssetBundle_GenericEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_assets_AssetBundle_GenericEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(tools.elide.model.Datamodel.role);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.google.protobuf.TimestampProto.getDescriptor();
    tools.elide.crypto.Crypto.getDescriptor();
    tools.elide.data.Data.getDescriptor();
    tools.elide.model.Datamodel.getDescriptor();
    tools.elide.struct.Bloom.getDescriptor();
    tools.elide.page.WebContext.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
