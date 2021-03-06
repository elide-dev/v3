// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: elide/crypto/crypto.proto

package tools.elide.crypto;

/**
 * <pre>
 * Specifies hash algorithms supported by the asset manifest code. We keep a token for this around so that we can
 * easily detect configuration changes and make evictions accordingly.
 * </pre>
 *
 * Protobuf enum {@code crypto.HashAlgorithm}
 */
public enum HashAlgorithm
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <pre>
   * No hash algorithm was/is active.
   * </pre>
   *
   * <code>IDENTITY = 0;</code>
   */
  IDENTITY(0),
  /**
   * <pre>
   * Use MD5 for chunk hashing.
   * </pre>
   *
   * <code>MD5 = 1;</code>
   */
  MD5(1),
  /**
   * <pre>
   * Use SHA1 for chunk hashing.
   * </pre>
   *
   * <code>SHA1 = 2;</code>
   */
  SHA1(2),
  /**
   * <pre>
   * Use SHA256 for chunk hashing.
   * </pre>
   *
   * <code>SHA256 = 3;</code>
   */
  SHA256(3),
  /**
   * <pre>
   * Use SHA512 for chunk hashing.
   * </pre>
   *
   * <code>SHA512 = 4;</code>
   */
  SHA512(4),
  /**
   * <pre>
   * Use SHA3-224 for chunk hashing.
   * </pre>
   *
   * <code>SHA3_224 = 5;</code>
   */
  SHA3_224(5),
  /**
   * <pre>
   * Use SHA3-256 for chunk hashing.
   * </pre>
   *
   * <code>SHA3_256 = 6;</code>
   */
  SHA3_256(6),
  /**
   * <pre>
   * Use SHA3-512 for chunk hashing.
   * </pre>
   *
   * <code>SHA3_512 = 7;</code>
   */
  SHA3_512(7),
  UNRECOGNIZED(-1),
  ;

  /**
   * <pre>
   * No hash algorithm was/is active.
   * </pre>
   *
   * <code>IDENTITY = 0;</code>
   */
  public static final int IDENTITY_VALUE = 0;
  /**
   * <pre>
   * Use MD5 for chunk hashing.
   * </pre>
   *
   * <code>MD5 = 1;</code>
   */
  public static final int MD5_VALUE = 1;
  /**
   * <pre>
   * Use SHA1 for chunk hashing.
   * </pre>
   *
   * <code>SHA1 = 2;</code>
   */
  public static final int SHA1_VALUE = 2;
  /**
   * <pre>
   * Use SHA256 for chunk hashing.
   * </pre>
   *
   * <code>SHA256 = 3;</code>
   */
  public static final int SHA256_VALUE = 3;
  /**
   * <pre>
   * Use SHA512 for chunk hashing.
   * </pre>
   *
   * <code>SHA512 = 4;</code>
   */
  public static final int SHA512_VALUE = 4;
  /**
   * <pre>
   * Use SHA3-224 for chunk hashing.
   * </pre>
   *
   * <code>SHA3_224 = 5;</code>
   */
  public static final int SHA3_224_VALUE = 5;
  /**
   * <pre>
   * Use SHA3-256 for chunk hashing.
   * </pre>
   *
   * <code>SHA3_256 = 6;</code>
   */
  public static final int SHA3_256_VALUE = 6;
  /**
   * <pre>
   * Use SHA3-512 for chunk hashing.
   * </pre>
   *
   * <code>SHA3_512 = 7;</code>
   */
  public static final int SHA3_512_VALUE = 7;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static HashAlgorithm valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static HashAlgorithm forNumber(int value) {
    switch (value) {
      case 0: return IDENTITY;
      case 1: return MD5;
      case 2: return SHA1;
      case 3: return SHA256;
      case 4: return SHA512;
      case 5: return SHA3_224;
      case 6: return SHA3_256;
      case 7: return SHA3_512;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<HashAlgorithm>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      HashAlgorithm> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<HashAlgorithm>() {
          public HashAlgorithm findValueByNumber(int number) {
            return HashAlgorithm.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return tools.elide.crypto.Crypto.getDescriptor().getEnumTypes().get(0);
  }

  private static final HashAlgorithm[] VALUES = values();

  public static HashAlgorithm valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private HashAlgorithm(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:crypto.HashAlgorithm)
}

