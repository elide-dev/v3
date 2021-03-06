//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: webutil/html/types/html.proto

package com.google.common.html.types;

@kotlin.jvm.JvmName("-initializesafeScriptProto")
public inline fun safeScriptProto(block: com.google.common.html.types.SafeScriptProtoKt.Dsl.() -> kotlin.Unit): com.google.common.html.types.SafeScriptProto =
  com.google.common.html.types.SafeScriptProtoKt.Dsl._create(com.google.common.html.types.SafeScriptProto.newBuilder()).apply { block() }._build()
public object SafeScriptProtoKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: com.google.common.html.types.SafeScriptProto.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: com.google.common.html.types.SafeScriptProto.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): com.google.common.html.types.SafeScriptProto = _builder.build()

    /**
     * <pre>
     * IMPORTANT: Never set or read this field, even from tests, it is private.
     * See documentation at the top of .proto file for programming language
     * packages with which to create or read this message.
     * </pre>
     *
     * <code>optional string private_do_not_access_or_else_safe_script_wrapped_value = 6 [ctype = CORD];</code>
     */
    public var privateDoNotAccessOrElseSafeScriptWrappedValue: kotlin.String
      @JvmName("getPrivateDoNotAccessOrElseSafeScriptWrappedValue")
      get() = _builder.getPrivateDoNotAccessOrElseSafeScriptWrappedValue()
      @JvmName("setPrivateDoNotAccessOrElseSafeScriptWrappedValue")
      set(value) {
        _builder.setPrivateDoNotAccessOrElseSafeScriptWrappedValue(value)
      }
    /**
     * <pre>
     * IMPORTANT: Never set or read this field, even from tests, it is private.
     * See documentation at the top of .proto file for programming language
     * packages with which to create or read this message.
     * </pre>
     *
     * <code>optional string private_do_not_access_or_else_safe_script_wrapped_value = 6 [ctype = CORD];</code>
     */
    public fun clearPrivateDoNotAccessOrElseSafeScriptWrappedValue() {
      _builder.clearPrivateDoNotAccessOrElseSafeScriptWrappedValue()
    }
    /**
     * <pre>
     * IMPORTANT: Never set or read this field, even from tests, it is private.
     * See documentation at the top of .proto file for programming language
     * packages with which to create or read this message.
     * </pre>
     *
     * <code>optional string private_do_not_access_or_else_safe_script_wrapped_value = 6 [ctype = CORD];</code>
     * @return Whether the privateDoNotAccessOrElseSafeScriptWrappedValue field is set.
     */
    public fun hasPrivateDoNotAccessOrElseSafeScriptWrappedValue(): kotlin.Boolean {
      return _builder.hasPrivateDoNotAccessOrElseSafeScriptWrappedValue()
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun com.google.common.html.types.SafeScriptProto.copy(block: com.google.common.html.types.SafeScriptProtoKt.Dsl.() -> kotlin.Unit): com.google.common.html.types.SafeScriptProto =
  com.google.common.html.types.SafeScriptProtoKt.Dsl._create(this.toBuilder()).apply { block() }._build()

