// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: LightService.proto

package LightService;

/**
 * Protobuf type {@code lights.GetRoomLightsResponse}
 */
public  final class GetRoomLightsResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:lights.GetRoomLightsResponse)
    GetRoomLightsResponseOrBuilder {
  // Use GetRoomLightsResponse.newBuilder() to construct.
  private GetRoomLightsResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetRoomLightsResponse() {
    lights_ = java.util.Collections.emptyList();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private GetRoomLightsResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              lights_ = new java.util.ArrayList<Light>();
              mutable_bitField0_ |= 0x00000001;
            }
            lights_.add(
                input.readMessage(Light.parser(), extensionRegistry));
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        lights_ = java.util.Collections.unmodifiableList(lights_);
      }
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return LightProto.internal_static_lights_GetRoomLightsResponse_descriptor;
  }

  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return LightProto.internal_static_lights_GetRoomLightsResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            GetRoomLightsResponse.class, Builder.class);
  }

  public static final int LIGHTS_FIELD_NUMBER = 1;
  private java.util.List<Light> lights_;
  /**
   * <code>repeated .lights.Light lights = 1;</code>
   */
  public java.util.List<Light> getLightsList() {
    return lights_;
  }
  /**
   * <code>repeated .lights.Light lights = 1;</code>
   */
  public java.util.List<? extends LightOrBuilder>
      getLightsOrBuilderList() {
    return lights_;
  }
  /**
   * <code>repeated .lights.Light lights = 1;</code>
   */
  public int getLightsCount() {
    return lights_.size();
  }
  /**
   * <code>repeated .lights.Light lights = 1;</code>
   */
  public Light getLights(int index) {
    return lights_.get(index);
  }
  /**
   * <code>repeated .lights.Light lights = 1;</code>
   */
  public LightOrBuilder getLightsOrBuilder(
      int index) {
    return lights_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < lights_.size(); i++) {
      output.writeMessage(1, lights_.get(i));
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < lights_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, lights_.get(i));
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof GetRoomLightsResponse)) {
      return super.equals(obj);
    }
    GetRoomLightsResponse other = (GetRoomLightsResponse) obj;

    boolean result = true;
    result = result && getLightsList()
        .equals(other.getLightsList());
    return result;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getLightsCount() > 0) {
      hash = (37 * hash) + LIGHTS_FIELD_NUMBER;
      hash = (53 * hash) + getLightsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static GetRoomLightsResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GetRoomLightsResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GetRoomLightsResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GetRoomLightsResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GetRoomLightsResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GetRoomLightsResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GetRoomLightsResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static GetRoomLightsResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static GetRoomLightsResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static GetRoomLightsResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static GetRoomLightsResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static GetRoomLightsResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(GetRoomLightsResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code lights.GetRoomLightsResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:lights.GetRoomLightsResponse)
      GetRoomLightsResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return LightProto.internal_static_lights_GetRoomLightsResponse_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return LightProto.internal_static_lights_GetRoomLightsResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              GetRoomLightsResponse.class, Builder.class);
    }

    // Construct using LightService.GetRoomLightsResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getLightsFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      if (lightsBuilder_ == null) {
        lights_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        lightsBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return LightProto.internal_static_lights_GetRoomLightsResponse_descriptor;
    }

    public GetRoomLightsResponse getDefaultInstanceForType() {
      return GetRoomLightsResponse.getDefaultInstance();
    }

    public GetRoomLightsResponse build() {
      GetRoomLightsResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public GetRoomLightsResponse buildPartial() {
      GetRoomLightsResponse result = new GetRoomLightsResponse(this);
      int from_bitField0_ = bitField0_;
      if (lightsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          lights_ = java.util.Collections.unmodifiableList(lights_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.lights_ = lights_;
      } else {
        result.lights_ = lightsBuilder_.build();
      }
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof GetRoomLightsResponse) {
        return mergeFrom((GetRoomLightsResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(GetRoomLightsResponse other) {
      if (other == GetRoomLightsResponse.getDefaultInstance()) return this;
      if (lightsBuilder_ == null) {
        if (!other.lights_.isEmpty()) {
          if (lights_.isEmpty()) {
            lights_ = other.lights_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureLightsIsMutable();
            lights_.addAll(other.lights_);
          }
          onChanged();
        }
      } else {
        if (!other.lights_.isEmpty()) {
          if (lightsBuilder_.isEmpty()) {
            lightsBuilder_.dispose();
            lightsBuilder_ = null;
            lights_ = other.lights_;
            bitField0_ = (bitField0_ & ~0x00000001);
            lightsBuilder_ =
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getLightsFieldBuilder() : null;
          } else {
            lightsBuilder_.addAllMessages(other.lights_);
          }
        }
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      GetRoomLightsResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (GetRoomLightsResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<Light> lights_ =
      java.util.Collections.emptyList();
    private void ensureLightsIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        lights_ = new java.util.ArrayList<Light>(lights_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        Light, Light.Builder, LightOrBuilder> lightsBuilder_;

    /**
     * <code>repeated .lights.Light lights = 1;</code>
     */
    public java.util.List<Light> getLightsList() {
      if (lightsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(lights_);
      } else {
        return lightsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .lights.Light lights = 1;</code>
     */
    public int getLightsCount() {
      if (lightsBuilder_ == null) {
        return lights_.size();
      } else {
        return lightsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .lights.Light lights = 1;</code>
     */
    public Light getLights(int index) {
      if (lightsBuilder_ == null) {
        return lights_.get(index);
      } else {
        return lightsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .lights.Light lights = 1;</code>
     */
    public Builder setLights(
        int index, Light value) {
      if (lightsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureLightsIsMutable();
        lights_.set(index, value);
        onChanged();
      } else {
        lightsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .lights.Light lights = 1;</code>
     */
    public Builder setLights(
        int index, Light.Builder builderForValue) {
      if (lightsBuilder_ == null) {
        ensureLightsIsMutable();
        lights_.set(index, builderForValue.build());
        onChanged();
      } else {
        lightsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .lights.Light lights = 1;</code>
     */
    public Builder addLights(Light value) {
      if (lightsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureLightsIsMutable();
        lights_.add(value);
        onChanged();
      } else {
        lightsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .lights.Light lights = 1;</code>
     */
    public Builder addLights(
        int index, Light value) {
      if (lightsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureLightsIsMutable();
        lights_.add(index, value);
        onChanged();
      } else {
        lightsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .lights.Light lights = 1;</code>
     */
    public Builder addLights(
        Light.Builder builderForValue) {
      if (lightsBuilder_ == null) {
        ensureLightsIsMutable();
        lights_.add(builderForValue.build());
        onChanged();
      } else {
        lightsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .lights.Light lights = 1;</code>
     */
    public Builder addLights(
        int index, Light.Builder builderForValue) {
      if (lightsBuilder_ == null) {
        ensureLightsIsMutable();
        lights_.add(index, builderForValue.build());
        onChanged();
      } else {
        lightsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .lights.Light lights = 1;</code>
     */
    public Builder addAllLights(
        Iterable<? extends Light> values) {
      if (lightsBuilder_ == null) {
        ensureLightsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, lights_);
        onChanged();
      } else {
        lightsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .lights.Light lights = 1;</code>
     */
    public Builder clearLights() {
      if (lightsBuilder_ == null) {
        lights_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        lightsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .lights.Light lights = 1;</code>
     */
    public Builder removeLights(int index) {
      if (lightsBuilder_ == null) {
        ensureLightsIsMutable();
        lights_.remove(index);
        onChanged();
      } else {
        lightsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .lights.Light lights = 1;</code>
     */
    public Light.Builder getLightsBuilder(
        int index) {
      return getLightsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .lights.Light lights = 1;</code>
     */
    public LightOrBuilder getLightsOrBuilder(
        int index) {
      if (lightsBuilder_ == null) {
        return lights_.get(index);  } else {
        return lightsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .lights.Light lights = 1;</code>
     */
    public java.util.List<? extends LightOrBuilder>
         getLightsOrBuilderList() {
      if (lightsBuilder_ != null) {
        return lightsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(lights_);
      }
    }
    /**
     * <code>repeated .lights.Light lights = 1;</code>
     */
    public Light.Builder addLightsBuilder() {
      return getLightsFieldBuilder().addBuilder(
          Light.getDefaultInstance());
    }
    /**
     * <code>repeated .lights.Light lights = 1;</code>
     */
    public Light.Builder addLightsBuilder(
        int index) {
      return getLightsFieldBuilder().addBuilder(
          index, Light.getDefaultInstance());
    }
    /**
     * <code>repeated .lights.Light lights = 1;</code>
     */
    public java.util.List<Light.Builder>
         getLightsBuilderList() {
      return getLightsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        Light, Light.Builder, LightOrBuilder>
        getLightsFieldBuilder() {
      if (lightsBuilder_ == null) {
        lightsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            Light, Light.Builder, LightOrBuilder>(
                lights_,
                ((bitField0_ & 0x00000001) == 0x00000001),
                getParentForChildren(),
                isClean());
        lights_ = null;
      }
      return lightsBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:lights.GetRoomLightsResponse)
  }

  // @@protoc_insertion_point(class_scope:lights.GetRoomLightsResponse)
  private static final GetRoomLightsResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new GetRoomLightsResponse();
  }

  public static GetRoomLightsResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetRoomLightsResponse>
      PARSER = new com.google.protobuf.AbstractParser<GetRoomLightsResponse>() {
    public GetRoomLightsResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new GetRoomLightsResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GetRoomLightsResponse> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<GetRoomLightsResponse> getParserForType() {
    return PARSER;
  }

  public GetRoomLightsResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

