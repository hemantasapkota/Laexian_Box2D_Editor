// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: com/laex/cg2d/model/SlootContent.proto

#define INTERNAL_SUPPRESS_PROTOBUF_FIELD_DEPRECATION
#include "com/laex/cg2d/model/SlootContent.pb.h"

#include <algorithm>

#include <google/protobuf/stubs/common.h>
#include <google/protobuf/stubs/once.h>
#include <google/protobuf/io/coded_stream.h>
#include <google/protobuf/wire_format_lite_inl.h>
#include <google/protobuf/descriptor.h>
#include <google/protobuf/generated_message_reflection.h>
#include <google/protobuf/reflection_ops.h>
#include <google/protobuf/wire_format.h>
// @@protoc_insertion_point(includes)

namespace com {
namespace laex {
namespace cg2d {
namespace model {

namespace {

const ::google::protobuf::Descriptor* SlootItem_descriptor_ = NULL;
const ::google::protobuf::internal::GeneratedMessageReflection*
  SlootItem_reflection_ = NULL;
const ::google::protobuf::Descriptor* SlootCollection_descriptor_ = NULL;
const ::google::protobuf::internal::GeneratedMessageReflection*
  SlootCollection_reflection_ = NULL;
const ::google::protobuf::Descriptor* SlootCollectionList_descriptor_ = NULL;
const ::google::protobuf::internal::GeneratedMessageReflection*
  SlootCollectionList_reflection_ = NULL;

}  // namespace


void protobuf_AssignDesc_com_2flaex_2fcg2d_2fmodel_2fSlootContent_2eproto() {
  protobuf_AddDesc_com_2flaex_2fcg2d_2fmodel_2fSlootContent_2eproto();
  const ::google::protobuf::FileDescriptor* file =
    ::google::protobuf::DescriptorPool::generated_pool()->FindFileByName(
      "com/laex/cg2d/model/SlootContent.proto");
  GOOGLE_CHECK(file != NULL);
  SlootItem_descriptor_ = file->message_type(0);
  static const int SlootItem_offsets_[4] = {
    GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(SlootItem, id_),
    GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(SlootItem, title_),
    GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(SlootItem, imgurl_),
    GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(SlootItem, price_),
  };
  SlootItem_reflection_ =
    new ::google::protobuf::internal::GeneratedMessageReflection(
      SlootItem_descriptor_,
      SlootItem::default_instance_,
      SlootItem_offsets_,
      GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(SlootItem, _has_bits_[0]),
      GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(SlootItem, _unknown_fields_),
      -1,
      ::google::protobuf::DescriptorPool::generated_pool(),
      ::google::protobuf::MessageFactory::generated_factory(),
      sizeof(SlootItem));
  SlootCollection_descriptor_ = file->message_type(1);
  static const int SlootCollection_offsets_[4] = {
    GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(SlootCollection, developerid_),
    GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(SlootCollection, slootcollectionid_),
    GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(SlootCollection, title_),
    GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(SlootCollection, slootitems_),
  };
  SlootCollection_reflection_ =
    new ::google::protobuf::internal::GeneratedMessageReflection(
      SlootCollection_descriptor_,
      SlootCollection::default_instance_,
      SlootCollection_offsets_,
      GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(SlootCollection, _has_bits_[0]),
      GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(SlootCollection, _unknown_fields_),
      -1,
      ::google::protobuf::DescriptorPool::generated_pool(),
      ::google::protobuf::MessageFactory::generated_factory(),
      sizeof(SlootCollection));
  SlootCollectionList_descriptor_ = file->message_type(2);
  static const int SlootCollectionList_offsets_[1] = {
    GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(SlootCollectionList, slootcollection_),
  };
  SlootCollectionList_reflection_ =
    new ::google::protobuf::internal::GeneratedMessageReflection(
      SlootCollectionList_descriptor_,
      SlootCollectionList::default_instance_,
      SlootCollectionList_offsets_,
      GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(SlootCollectionList, _has_bits_[0]),
      GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(SlootCollectionList, _unknown_fields_),
      -1,
      ::google::protobuf::DescriptorPool::generated_pool(),
      ::google::protobuf::MessageFactory::generated_factory(),
      sizeof(SlootCollectionList));
}

namespace {

GOOGLE_PROTOBUF_DECLARE_ONCE(protobuf_AssignDescriptors_once_);
inline void protobuf_AssignDescriptorsOnce() {
  ::google::protobuf::GoogleOnceInit(&protobuf_AssignDescriptors_once_,
                 &protobuf_AssignDesc_com_2flaex_2fcg2d_2fmodel_2fSlootContent_2eproto);
}

void protobuf_RegisterTypes(const ::std::string&) {
  protobuf_AssignDescriptorsOnce();
  ::google::protobuf::MessageFactory::InternalRegisterGeneratedMessage(
    SlootItem_descriptor_, &SlootItem::default_instance());
  ::google::protobuf::MessageFactory::InternalRegisterGeneratedMessage(
    SlootCollection_descriptor_, &SlootCollection::default_instance());
  ::google::protobuf::MessageFactory::InternalRegisterGeneratedMessage(
    SlootCollectionList_descriptor_, &SlootCollectionList::default_instance());
}

}  // namespace

void protobuf_ShutdownFile_com_2flaex_2fcg2d_2fmodel_2fSlootContent_2eproto() {
  delete SlootItem::default_instance_;
  delete SlootItem_reflection_;
  delete SlootCollection::default_instance_;
  delete SlootCollection_reflection_;
  delete SlootCollectionList::default_instance_;
  delete SlootCollectionList_reflection_;
}

void protobuf_AddDesc_com_2flaex_2fcg2d_2fmodel_2fSlootContent_2eproto() {
  static bool already_here = false;
  if (already_here) return;
  already_here = true;
  GOOGLE_PROTOBUF_VERIFY_VERSION;

  ::google::protobuf::DescriptorPool::InternalAddGeneratedFile(
    "\n&com/laex/cg2d/model/SlootContent.proto"
    "\022\023com.laex.cg2d.model\"E\n\tSlootItem\022\n\n\002id"
    "\030\001 \001(\t\022\r\n\005title\030\002 \001(\t\022\016\n\006imgUrl\030\003 \001(\t\022\r\n"
    "\005price\030\004 \001(\002\"\204\001\n\017SlootCollection\022\023\n\013deve"
    "loperId\030\001 \001(\t\022\031\n\021slootCollectionId\030\002 \001(\t"
    "\022\r\n\005title\030\003 \001(\t\0222\n\nslootItems\030\004 \003(\0132\036.co"
    "m.laex.cg2d.model.SlootItem\"T\n\023SlootColl"
    "ectionList\022=\n\017slootCollection\030\001 \003(\0132$.co"
    "m.laex.cg2d.model.SlootCollection", 353);
  ::google::protobuf::MessageFactory::InternalRegisterGeneratedFile(
    "com/laex/cg2d/model/SlootContent.proto", &protobuf_RegisterTypes);
  SlootItem::default_instance_ = new SlootItem();
  SlootCollection::default_instance_ = new SlootCollection();
  SlootCollectionList::default_instance_ = new SlootCollectionList();
  SlootItem::default_instance_->InitAsDefaultInstance();
  SlootCollection::default_instance_->InitAsDefaultInstance();
  SlootCollectionList::default_instance_->InitAsDefaultInstance();
  ::google::protobuf::internal::OnShutdown(&protobuf_ShutdownFile_com_2flaex_2fcg2d_2fmodel_2fSlootContent_2eproto);
}

// Force AddDescriptors() to be called at static initialization time.
struct StaticDescriptorInitializer_com_2flaex_2fcg2d_2fmodel_2fSlootContent_2eproto {
  StaticDescriptorInitializer_com_2flaex_2fcg2d_2fmodel_2fSlootContent_2eproto() {
    protobuf_AddDesc_com_2flaex_2fcg2d_2fmodel_2fSlootContent_2eproto();
  }
} static_descriptor_initializer_com_2flaex_2fcg2d_2fmodel_2fSlootContent_2eproto_;

// ===================================================================

#ifndef _MSC_VER
const int SlootItem::kIdFieldNumber;
const int SlootItem::kTitleFieldNumber;
const int SlootItem::kImgUrlFieldNumber;
const int SlootItem::kPriceFieldNumber;
#endif  // !_MSC_VER

SlootItem::SlootItem()
  : ::google::protobuf::Message() {
  SharedCtor();
}

void SlootItem::InitAsDefaultInstance() {
}

SlootItem::SlootItem(const SlootItem& from)
  : ::google::protobuf::Message() {
  SharedCtor();
  MergeFrom(from);
}

void SlootItem::SharedCtor() {
  _cached_size_ = 0;
  id_ = const_cast< ::std::string*>(&::google::protobuf::internal::kEmptyString);
  title_ = const_cast< ::std::string*>(&::google::protobuf::internal::kEmptyString);
  imgurl_ = const_cast< ::std::string*>(&::google::protobuf::internal::kEmptyString);
  price_ = 0;
  ::memset(_has_bits_, 0, sizeof(_has_bits_));
}

SlootItem::~SlootItem() {
  SharedDtor();
}

void SlootItem::SharedDtor() {
  if (id_ != &::google::protobuf::internal::kEmptyString) {
    delete id_;
  }
  if (title_ != &::google::protobuf::internal::kEmptyString) {
    delete title_;
  }
  if (imgurl_ != &::google::protobuf::internal::kEmptyString) {
    delete imgurl_;
  }
  if (this != default_instance_) {
  }
}

void SlootItem::SetCachedSize(int size) const {
  GOOGLE_SAFE_CONCURRENT_WRITES_BEGIN();
  _cached_size_ = size;
  GOOGLE_SAFE_CONCURRENT_WRITES_END();
}
const ::google::protobuf::Descriptor* SlootItem::descriptor() {
  protobuf_AssignDescriptorsOnce();
  return SlootItem_descriptor_;
}

const SlootItem& SlootItem::default_instance() {
  if (default_instance_ == NULL) protobuf_AddDesc_com_2flaex_2fcg2d_2fmodel_2fSlootContent_2eproto();
  return *default_instance_;
}

SlootItem* SlootItem::default_instance_ = NULL;

SlootItem* SlootItem::New() const {
  return new SlootItem;
}

void SlootItem::Clear() {
  if (_has_bits_[0 / 32] & (0xffu << (0 % 32))) {
    if (has_id()) {
      if (id_ != &::google::protobuf::internal::kEmptyString) {
        id_->clear();
      }
    }
    if (has_title()) {
      if (title_ != &::google::protobuf::internal::kEmptyString) {
        title_->clear();
      }
    }
    if (has_imgurl()) {
      if (imgurl_ != &::google::protobuf::internal::kEmptyString) {
        imgurl_->clear();
      }
    }
    price_ = 0;
  }
  ::memset(_has_bits_, 0, sizeof(_has_bits_));
  mutable_unknown_fields()->Clear();
}

bool SlootItem::MergePartialFromCodedStream(
    ::google::protobuf::io::CodedInputStream* input) {
#define DO_(EXPRESSION) if (!(EXPRESSION)) return false
  ::google::protobuf::uint32 tag;
  while ((tag = input->ReadTag()) != 0) {
    switch (::google::protobuf::internal::WireFormatLite::GetTagFieldNumber(tag)) {
      // optional string id = 1;
      case 1: {
        if (::google::protobuf::internal::WireFormatLite::GetTagWireType(tag) ==
            ::google::protobuf::internal::WireFormatLite::WIRETYPE_LENGTH_DELIMITED) {
          DO_(::google::protobuf::internal::WireFormatLite::ReadString(
                input, this->mutable_id()));
          ::google::protobuf::internal::WireFormat::VerifyUTF8String(
            this->id().data(), this->id().length(),
            ::google::protobuf::internal::WireFormat::PARSE);
        } else {
          goto handle_uninterpreted;
        }
        if (input->ExpectTag(18)) goto parse_title;
        break;
      }

      // optional string title = 2;
      case 2: {
        if (::google::protobuf::internal::WireFormatLite::GetTagWireType(tag) ==
            ::google::protobuf::internal::WireFormatLite::WIRETYPE_LENGTH_DELIMITED) {
         parse_title:
          DO_(::google::protobuf::internal::WireFormatLite::ReadString(
                input, this->mutable_title()));
          ::google::protobuf::internal::WireFormat::VerifyUTF8String(
            this->title().data(), this->title().length(),
            ::google::protobuf::internal::WireFormat::PARSE);
        } else {
          goto handle_uninterpreted;
        }
        if (input->ExpectTag(26)) goto parse_imgUrl;
        break;
      }

      // optional string imgUrl = 3;
      case 3: {
        if (::google::protobuf::internal::WireFormatLite::GetTagWireType(tag) ==
            ::google::protobuf::internal::WireFormatLite::WIRETYPE_LENGTH_DELIMITED) {
         parse_imgUrl:
          DO_(::google::protobuf::internal::WireFormatLite::ReadString(
                input, this->mutable_imgurl()));
          ::google::protobuf::internal::WireFormat::VerifyUTF8String(
            this->imgurl().data(), this->imgurl().length(),
            ::google::protobuf::internal::WireFormat::PARSE);
        } else {
          goto handle_uninterpreted;
        }
        if (input->ExpectTag(37)) goto parse_price;
        break;
      }

      // optional float price = 4;
      case 4: {
        if (::google::protobuf::internal::WireFormatLite::GetTagWireType(tag) ==
            ::google::protobuf::internal::WireFormatLite::WIRETYPE_FIXED32) {
         parse_price:
          DO_((::google::protobuf::internal::WireFormatLite::ReadPrimitive<
                   float, ::google::protobuf::internal::WireFormatLite::TYPE_FLOAT>(
                 input, &price_)));
          set_has_price();
        } else {
          goto handle_uninterpreted;
        }
        if (input->ExpectAtEnd()) return true;
        break;
      }

      default: {
      handle_uninterpreted:
        if (::google::protobuf::internal::WireFormatLite::GetTagWireType(tag) ==
            ::google::protobuf::internal::WireFormatLite::WIRETYPE_END_GROUP) {
          return true;
        }
        DO_(::google::protobuf::internal::WireFormat::SkipField(
              input, tag, mutable_unknown_fields()));
        break;
      }
    }
  }
  return true;
#undef DO_
}

void SlootItem::SerializeWithCachedSizes(
    ::google::protobuf::io::CodedOutputStream* output) const {
  // optional string id = 1;
  if (has_id()) {
    ::google::protobuf::internal::WireFormat::VerifyUTF8String(
      this->id().data(), this->id().length(),
      ::google::protobuf::internal::WireFormat::SERIALIZE);
    ::google::protobuf::internal::WireFormatLite::WriteString(
      1, this->id(), output);
  }

  // optional string title = 2;
  if (has_title()) {
    ::google::protobuf::internal::WireFormat::VerifyUTF8String(
      this->title().data(), this->title().length(),
      ::google::protobuf::internal::WireFormat::SERIALIZE);
    ::google::protobuf::internal::WireFormatLite::WriteString(
      2, this->title(), output);
  }

  // optional string imgUrl = 3;
  if (has_imgurl()) {
    ::google::protobuf::internal::WireFormat::VerifyUTF8String(
      this->imgurl().data(), this->imgurl().length(),
      ::google::protobuf::internal::WireFormat::SERIALIZE);
    ::google::protobuf::internal::WireFormatLite::WriteString(
      3, this->imgurl(), output);
  }

  // optional float price = 4;
  if (has_price()) {
    ::google::protobuf::internal::WireFormatLite::WriteFloat(4, this->price(), output);
  }

  if (!unknown_fields().empty()) {
    ::google::protobuf::internal::WireFormat::SerializeUnknownFields(
        unknown_fields(), output);
  }
}

::google::protobuf::uint8* SlootItem::SerializeWithCachedSizesToArray(
    ::google::protobuf::uint8* target) const {
  // optional string id = 1;
  if (has_id()) {
    ::google::protobuf::internal::WireFormat::VerifyUTF8String(
      this->id().data(), this->id().length(),
      ::google::protobuf::internal::WireFormat::SERIALIZE);
    target =
      ::google::protobuf::internal::WireFormatLite::WriteStringToArray(
        1, this->id(), target);
  }

  // optional string title = 2;
  if (has_title()) {
    ::google::protobuf::internal::WireFormat::VerifyUTF8String(
      this->title().data(), this->title().length(),
      ::google::protobuf::internal::WireFormat::SERIALIZE);
    target =
      ::google::protobuf::internal::WireFormatLite::WriteStringToArray(
        2, this->title(), target);
  }

  // optional string imgUrl = 3;
  if (has_imgurl()) {
    ::google::protobuf::internal::WireFormat::VerifyUTF8String(
      this->imgurl().data(), this->imgurl().length(),
      ::google::protobuf::internal::WireFormat::SERIALIZE);
    target =
      ::google::protobuf::internal::WireFormatLite::WriteStringToArray(
        3, this->imgurl(), target);
  }

  // optional float price = 4;
  if (has_price()) {
    target = ::google::protobuf::internal::WireFormatLite::WriteFloatToArray(4, this->price(), target);
  }

  if (!unknown_fields().empty()) {
    target = ::google::protobuf::internal::WireFormat::SerializeUnknownFieldsToArray(
        unknown_fields(), target);
  }
  return target;
}

int SlootItem::ByteSize() const {
  int total_size = 0;

  if (_has_bits_[0 / 32] & (0xffu << (0 % 32))) {
    // optional string id = 1;
    if (has_id()) {
      total_size += 1 +
        ::google::protobuf::internal::WireFormatLite::StringSize(
          this->id());
    }

    // optional string title = 2;
    if (has_title()) {
      total_size += 1 +
        ::google::protobuf::internal::WireFormatLite::StringSize(
          this->title());
    }

    // optional string imgUrl = 3;
    if (has_imgurl()) {
      total_size += 1 +
        ::google::protobuf::internal::WireFormatLite::StringSize(
          this->imgurl());
    }

    // optional float price = 4;
    if (has_price()) {
      total_size += 1 + 4;
    }

  }
  if (!unknown_fields().empty()) {
    total_size +=
      ::google::protobuf::internal::WireFormat::ComputeUnknownFieldsSize(
        unknown_fields());
  }
  GOOGLE_SAFE_CONCURRENT_WRITES_BEGIN();
  _cached_size_ = total_size;
  GOOGLE_SAFE_CONCURRENT_WRITES_END();
  return total_size;
}

void SlootItem::MergeFrom(const ::google::protobuf::Message& from) {
  GOOGLE_CHECK_NE(&from, this);
  const SlootItem* source =
    ::google::protobuf::internal::dynamic_cast_if_available<const SlootItem*>(
      &from);
  if (source == NULL) {
    ::google::protobuf::internal::ReflectionOps::Merge(from, this);
  } else {
    MergeFrom(*source);
  }
}

void SlootItem::MergeFrom(const SlootItem& from) {
  GOOGLE_CHECK_NE(&from, this);
  if (from._has_bits_[0 / 32] & (0xffu << (0 % 32))) {
    if (from.has_id()) {
      set_id(from.id());
    }
    if (from.has_title()) {
      set_title(from.title());
    }
    if (from.has_imgurl()) {
      set_imgurl(from.imgurl());
    }
    if (from.has_price()) {
      set_price(from.price());
    }
  }
  mutable_unknown_fields()->MergeFrom(from.unknown_fields());
}

void SlootItem::CopyFrom(const ::google::protobuf::Message& from) {
  if (&from == this) return;
  Clear();
  MergeFrom(from);
}

void SlootItem::CopyFrom(const SlootItem& from) {
  if (&from == this) return;
  Clear();
  MergeFrom(from);
}

bool SlootItem::IsInitialized() const {

  return true;
}

void SlootItem::Swap(SlootItem* other) {
  if (other != this) {
    std::swap(id_, other->id_);
    std::swap(title_, other->title_);
    std::swap(imgurl_, other->imgurl_);
    std::swap(price_, other->price_);
    std::swap(_has_bits_[0], other->_has_bits_[0]);
    _unknown_fields_.Swap(&other->_unknown_fields_);
    std::swap(_cached_size_, other->_cached_size_);
  }
}

::google::protobuf::Metadata SlootItem::GetMetadata() const {
  protobuf_AssignDescriptorsOnce();
  ::google::protobuf::Metadata metadata;
  metadata.descriptor = SlootItem_descriptor_;
  metadata.reflection = SlootItem_reflection_;
  return metadata;
}


// ===================================================================

#ifndef _MSC_VER
const int SlootCollection::kDeveloperIdFieldNumber;
const int SlootCollection::kSlootCollectionIdFieldNumber;
const int SlootCollection::kTitleFieldNumber;
const int SlootCollection::kSlootItemsFieldNumber;
#endif  // !_MSC_VER

SlootCollection::SlootCollection()
  : ::google::protobuf::Message() {
  SharedCtor();
}

void SlootCollection::InitAsDefaultInstance() {
}

SlootCollection::SlootCollection(const SlootCollection& from)
  : ::google::protobuf::Message() {
  SharedCtor();
  MergeFrom(from);
}

void SlootCollection::SharedCtor() {
  _cached_size_ = 0;
  developerid_ = const_cast< ::std::string*>(&::google::protobuf::internal::kEmptyString);
  slootcollectionid_ = const_cast< ::std::string*>(&::google::protobuf::internal::kEmptyString);
  title_ = const_cast< ::std::string*>(&::google::protobuf::internal::kEmptyString);
  ::memset(_has_bits_, 0, sizeof(_has_bits_));
}

SlootCollection::~SlootCollection() {
  SharedDtor();
}

void SlootCollection::SharedDtor() {
  if (developerid_ != &::google::protobuf::internal::kEmptyString) {
    delete developerid_;
  }
  if (slootcollectionid_ != &::google::protobuf::internal::kEmptyString) {
    delete slootcollectionid_;
  }
  if (title_ != &::google::protobuf::internal::kEmptyString) {
    delete title_;
  }
  if (this != default_instance_) {
  }
}

void SlootCollection::SetCachedSize(int size) const {
  GOOGLE_SAFE_CONCURRENT_WRITES_BEGIN();
  _cached_size_ = size;
  GOOGLE_SAFE_CONCURRENT_WRITES_END();
}
const ::google::protobuf::Descriptor* SlootCollection::descriptor() {
  protobuf_AssignDescriptorsOnce();
  return SlootCollection_descriptor_;
}

const SlootCollection& SlootCollection::default_instance() {
  if (default_instance_ == NULL) protobuf_AddDesc_com_2flaex_2fcg2d_2fmodel_2fSlootContent_2eproto();
  return *default_instance_;
}

SlootCollection* SlootCollection::default_instance_ = NULL;

SlootCollection* SlootCollection::New() const {
  return new SlootCollection;
}

void SlootCollection::Clear() {
  if (_has_bits_[0 / 32] & (0xffu << (0 % 32))) {
    if (has_developerid()) {
      if (developerid_ != &::google::protobuf::internal::kEmptyString) {
        developerid_->clear();
      }
    }
    if (has_slootcollectionid()) {
      if (slootcollectionid_ != &::google::protobuf::internal::kEmptyString) {
        slootcollectionid_->clear();
      }
    }
    if (has_title()) {
      if (title_ != &::google::protobuf::internal::kEmptyString) {
        title_->clear();
      }
    }
  }
  slootitems_.Clear();
  ::memset(_has_bits_, 0, sizeof(_has_bits_));
  mutable_unknown_fields()->Clear();
}

bool SlootCollection::MergePartialFromCodedStream(
    ::google::protobuf::io::CodedInputStream* input) {
#define DO_(EXPRESSION) if (!(EXPRESSION)) return false
  ::google::protobuf::uint32 tag;
  while ((tag = input->ReadTag()) != 0) {
    switch (::google::protobuf::internal::WireFormatLite::GetTagFieldNumber(tag)) {
      // optional string developerId = 1;
      case 1: {
        if (::google::protobuf::internal::WireFormatLite::GetTagWireType(tag) ==
            ::google::protobuf::internal::WireFormatLite::WIRETYPE_LENGTH_DELIMITED) {
          DO_(::google::protobuf::internal::WireFormatLite::ReadString(
                input, this->mutable_developerid()));
          ::google::protobuf::internal::WireFormat::VerifyUTF8String(
            this->developerid().data(), this->developerid().length(),
            ::google::protobuf::internal::WireFormat::PARSE);
        } else {
          goto handle_uninterpreted;
        }
        if (input->ExpectTag(18)) goto parse_slootCollectionId;
        break;
      }

      // optional string slootCollectionId = 2;
      case 2: {
        if (::google::protobuf::internal::WireFormatLite::GetTagWireType(tag) ==
            ::google::protobuf::internal::WireFormatLite::WIRETYPE_LENGTH_DELIMITED) {
         parse_slootCollectionId:
          DO_(::google::protobuf::internal::WireFormatLite::ReadString(
                input, this->mutable_slootcollectionid()));
          ::google::protobuf::internal::WireFormat::VerifyUTF8String(
            this->slootcollectionid().data(), this->slootcollectionid().length(),
            ::google::protobuf::internal::WireFormat::PARSE);
        } else {
          goto handle_uninterpreted;
        }
        if (input->ExpectTag(26)) goto parse_title;
        break;
      }

      // optional string title = 3;
      case 3: {
        if (::google::protobuf::internal::WireFormatLite::GetTagWireType(tag) ==
            ::google::protobuf::internal::WireFormatLite::WIRETYPE_LENGTH_DELIMITED) {
         parse_title:
          DO_(::google::protobuf::internal::WireFormatLite::ReadString(
                input, this->mutable_title()));
          ::google::protobuf::internal::WireFormat::VerifyUTF8String(
            this->title().data(), this->title().length(),
            ::google::protobuf::internal::WireFormat::PARSE);
        } else {
          goto handle_uninterpreted;
        }
        if (input->ExpectTag(34)) goto parse_slootItems;
        break;
      }

      // repeated .com.laex.cg2d.model.SlootItem slootItems = 4;
      case 4: {
        if (::google::protobuf::internal::WireFormatLite::GetTagWireType(tag) ==
            ::google::protobuf::internal::WireFormatLite::WIRETYPE_LENGTH_DELIMITED) {
         parse_slootItems:
          DO_(::google::protobuf::internal::WireFormatLite::ReadMessageNoVirtual(
                input, add_slootitems()));
        } else {
          goto handle_uninterpreted;
        }
        if (input->ExpectTag(34)) goto parse_slootItems;
        if (input->ExpectAtEnd()) return true;
        break;
      }

      default: {
      handle_uninterpreted:
        if (::google::protobuf::internal::WireFormatLite::GetTagWireType(tag) ==
            ::google::protobuf::internal::WireFormatLite::WIRETYPE_END_GROUP) {
          return true;
        }
        DO_(::google::protobuf::internal::WireFormat::SkipField(
              input, tag, mutable_unknown_fields()));
        break;
      }
    }
  }
  return true;
#undef DO_
}

void SlootCollection::SerializeWithCachedSizes(
    ::google::protobuf::io::CodedOutputStream* output) const {
  // optional string developerId = 1;
  if (has_developerid()) {
    ::google::protobuf::internal::WireFormat::VerifyUTF8String(
      this->developerid().data(), this->developerid().length(),
      ::google::protobuf::internal::WireFormat::SERIALIZE);
    ::google::protobuf::internal::WireFormatLite::WriteString(
      1, this->developerid(), output);
  }

  // optional string slootCollectionId = 2;
  if (has_slootcollectionid()) {
    ::google::protobuf::internal::WireFormat::VerifyUTF8String(
      this->slootcollectionid().data(), this->slootcollectionid().length(),
      ::google::protobuf::internal::WireFormat::SERIALIZE);
    ::google::protobuf::internal::WireFormatLite::WriteString(
      2, this->slootcollectionid(), output);
  }

  // optional string title = 3;
  if (has_title()) {
    ::google::protobuf::internal::WireFormat::VerifyUTF8String(
      this->title().data(), this->title().length(),
      ::google::protobuf::internal::WireFormat::SERIALIZE);
    ::google::protobuf::internal::WireFormatLite::WriteString(
      3, this->title(), output);
  }

  // repeated .com.laex.cg2d.model.SlootItem slootItems = 4;
  for (int i = 0; i < this->slootitems_size(); i++) {
    ::google::protobuf::internal::WireFormatLite::WriteMessageMaybeToArray(
      4, this->slootitems(i), output);
  }

  if (!unknown_fields().empty()) {
    ::google::protobuf::internal::WireFormat::SerializeUnknownFields(
        unknown_fields(), output);
  }
}

::google::protobuf::uint8* SlootCollection::SerializeWithCachedSizesToArray(
    ::google::protobuf::uint8* target) const {
  // optional string developerId = 1;
  if (has_developerid()) {
    ::google::protobuf::internal::WireFormat::VerifyUTF8String(
      this->developerid().data(), this->developerid().length(),
      ::google::protobuf::internal::WireFormat::SERIALIZE);
    target =
      ::google::protobuf::internal::WireFormatLite::WriteStringToArray(
        1, this->developerid(), target);
  }

  // optional string slootCollectionId = 2;
  if (has_slootcollectionid()) {
    ::google::protobuf::internal::WireFormat::VerifyUTF8String(
      this->slootcollectionid().data(), this->slootcollectionid().length(),
      ::google::protobuf::internal::WireFormat::SERIALIZE);
    target =
      ::google::protobuf::internal::WireFormatLite::WriteStringToArray(
        2, this->slootcollectionid(), target);
  }

  // optional string title = 3;
  if (has_title()) {
    ::google::protobuf::internal::WireFormat::VerifyUTF8String(
      this->title().data(), this->title().length(),
      ::google::protobuf::internal::WireFormat::SERIALIZE);
    target =
      ::google::protobuf::internal::WireFormatLite::WriteStringToArray(
        3, this->title(), target);
  }

  // repeated .com.laex.cg2d.model.SlootItem slootItems = 4;
  for (int i = 0; i < this->slootitems_size(); i++) {
    target = ::google::protobuf::internal::WireFormatLite::
      WriteMessageNoVirtualToArray(
        4, this->slootitems(i), target);
  }

  if (!unknown_fields().empty()) {
    target = ::google::protobuf::internal::WireFormat::SerializeUnknownFieldsToArray(
        unknown_fields(), target);
  }
  return target;
}

int SlootCollection::ByteSize() const {
  int total_size = 0;

  if (_has_bits_[0 / 32] & (0xffu << (0 % 32))) {
    // optional string developerId = 1;
    if (has_developerid()) {
      total_size += 1 +
        ::google::protobuf::internal::WireFormatLite::StringSize(
          this->developerid());
    }

    // optional string slootCollectionId = 2;
    if (has_slootcollectionid()) {
      total_size += 1 +
        ::google::protobuf::internal::WireFormatLite::StringSize(
          this->slootcollectionid());
    }

    // optional string title = 3;
    if (has_title()) {
      total_size += 1 +
        ::google::protobuf::internal::WireFormatLite::StringSize(
          this->title());
    }

  }
  // repeated .com.laex.cg2d.model.SlootItem slootItems = 4;
  total_size += 1 * this->slootitems_size();
  for (int i = 0; i < this->slootitems_size(); i++) {
    total_size +=
      ::google::protobuf::internal::WireFormatLite::MessageSizeNoVirtual(
        this->slootitems(i));
  }

  if (!unknown_fields().empty()) {
    total_size +=
      ::google::protobuf::internal::WireFormat::ComputeUnknownFieldsSize(
        unknown_fields());
  }
  GOOGLE_SAFE_CONCURRENT_WRITES_BEGIN();
  _cached_size_ = total_size;
  GOOGLE_SAFE_CONCURRENT_WRITES_END();
  return total_size;
}

void SlootCollection::MergeFrom(const ::google::protobuf::Message& from) {
  GOOGLE_CHECK_NE(&from, this);
  const SlootCollection* source =
    ::google::protobuf::internal::dynamic_cast_if_available<const SlootCollection*>(
      &from);
  if (source == NULL) {
    ::google::protobuf::internal::ReflectionOps::Merge(from, this);
  } else {
    MergeFrom(*source);
  }
}

void SlootCollection::MergeFrom(const SlootCollection& from) {
  GOOGLE_CHECK_NE(&from, this);
  slootitems_.MergeFrom(from.slootitems_);
  if (from._has_bits_[0 / 32] & (0xffu << (0 % 32))) {
    if (from.has_developerid()) {
      set_developerid(from.developerid());
    }
    if (from.has_slootcollectionid()) {
      set_slootcollectionid(from.slootcollectionid());
    }
    if (from.has_title()) {
      set_title(from.title());
    }
  }
  mutable_unknown_fields()->MergeFrom(from.unknown_fields());
}

void SlootCollection::CopyFrom(const ::google::protobuf::Message& from) {
  if (&from == this) return;
  Clear();
  MergeFrom(from);
}

void SlootCollection::CopyFrom(const SlootCollection& from) {
  if (&from == this) return;
  Clear();
  MergeFrom(from);
}

bool SlootCollection::IsInitialized() const {

  return true;
}

void SlootCollection::Swap(SlootCollection* other) {
  if (other != this) {
    std::swap(developerid_, other->developerid_);
    std::swap(slootcollectionid_, other->slootcollectionid_);
    std::swap(title_, other->title_);
    slootitems_.Swap(&other->slootitems_);
    std::swap(_has_bits_[0], other->_has_bits_[0]);
    _unknown_fields_.Swap(&other->_unknown_fields_);
    std::swap(_cached_size_, other->_cached_size_);
  }
}

::google::protobuf::Metadata SlootCollection::GetMetadata() const {
  protobuf_AssignDescriptorsOnce();
  ::google::protobuf::Metadata metadata;
  metadata.descriptor = SlootCollection_descriptor_;
  metadata.reflection = SlootCollection_reflection_;
  return metadata;
}


// ===================================================================

#ifndef _MSC_VER
const int SlootCollectionList::kSlootCollectionFieldNumber;
#endif  // !_MSC_VER

SlootCollectionList::SlootCollectionList()
  : ::google::protobuf::Message() {
  SharedCtor();
}

void SlootCollectionList::InitAsDefaultInstance() {
}

SlootCollectionList::SlootCollectionList(const SlootCollectionList& from)
  : ::google::protobuf::Message() {
  SharedCtor();
  MergeFrom(from);
}

void SlootCollectionList::SharedCtor() {
  _cached_size_ = 0;
  ::memset(_has_bits_, 0, sizeof(_has_bits_));
}

SlootCollectionList::~SlootCollectionList() {
  SharedDtor();
}

void SlootCollectionList::SharedDtor() {
  if (this != default_instance_) {
  }
}

void SlootCollectionList::SetCachedSize(int size) const {
  GOOGLE_SAFE_CONCURRENT_WRITES_BEGIN();
  _cached_size_ = size;
  GOOGLE_SAFE_CONCURRENT_WRITES_END();
}
const ::google::protobuf::Descriptor* SlootCollectionList::descriptor() {
  protobuf_AssignDescriptorsOnce();
  return SlootCollectionList_descriptor_;
}

const SlootCollectionList& SlootCollectionList::default_instance() {
  if (default_instance_ == NULL) protobuf_AddDesc_com_2flaex_2fcg2d_2fmodel_2fSlootContent_2eproto();
  return *default_instance_;
}

SlootCollectionList* SlootCollectionList::default_instance_ = NULL;

SlootCollectionList* SlootCollectionList::New() const {
  return new SlootCollectionList;
}

void SlootCollectionList::Clear() {
  slootcollection_.Clear();
  ::memset(_has_bits_, 0, sizeof(_has_bits_));
  mutable_unknown_fields()->Clear();
}

bool SlootCollectionList::MergePartialFromCodedStream(
    ::google::protobuf::io::CodedInputStream* input) {
#define DO_(EXPRESSION) if (!(EXPRESSION)) return false
  ::google::protobuf::uint32 tag;
  while ((tag = input->ReadTag()) != 0) {
    switch (::google::protobuf::internal::WireFormatLite::GetTagFieldNumber(tag)) {
      // repeated .com.laex.cg2d.model.SlootCollection slootCollection = 1;
      case 1: {
        if (::google::protobuf::internal::WireFormatLite::GetTagWireType(tag) ==
            ::google::protobuf::internal::WireFormatLite::WIRETYPE_LENGTH_DELIMITED) {
         parse_slootCollection:
          DO_(::google::protobuf::internal::WireFormatLite::ReadMessageNoVirtual(
                input, add_slootcollection()));
        } else {
          goto handle_uninterpreted;
        }
        if (input->ExpectTag(10)) goto parse_slootCollection;
        if (input->ExpectAtEnd()) return true;
        break;
      }

      default: {
      handle_uninterpreted:
        if (::google::protobuf::internal::WireFormatLite::GetTagWireType(tag) ==
            ::google::protobuf::internal::WireFormatLite::WIRETYPE_END_GROUP) {
          return true;
        }
        DO_(::google::protobuf::internal::WireFormat::SkipField(
              input, tag, mutable_unknown_fields()));
        break;
      }
    }
  }
  return true;
#undef DO_
}

void SlootCollectionList::SerializeWithCachedSizes(
    ::google::protobuf::io::CodedOutputStream* output) const {
  // repeated .com.laex.cg2d.model.SlootCollection slootCollection = 1;
  for (int i = 0; i < this->slootcollection_size(); i++) {
    ::google::protobuf::internal::WireFormatLite::WriteMessageMaybeToArray(
      1, this->slootcollection(i), output);
  }

  if (!unknown_fields().empty()) {
    ::google::protobuf::internal::WireFormat::SerializeUnknownFields(
        unknown_fields(), output);
  }
}

::google::protobuf::uint8* SlootCollectionList::SerializeWithCachedSizesToArray(
    ::google::protobuf::uint8* target) const {
  // repeated .com.laex.cg2d.model.SlootCollection slootCollection = 1;
  for (int i = 0; i < this->slootcollection_size(); i++) {
    target = ::google::protobuf::internal::WireFormatLite::
      WriteMessageNoVirtualToArray(
        1, this->slootcollection(i), target);
  }

  if (!unknown_fields().empty()) {
    target = ::google::protobuf::internal::WireFormat::SerializeUnknownFieldsToArray(
        unknown_fields(), target);
  }
  return target;
}

int SlootCollectionList::ByteSize() const {
  int total_size = 0;

  // repeated .com.laex.cg2d.model.SlootCollection slootCollection = 1;
  total_size += 1 * this->slootcollection_size();
  for (int i = 0; i < this->slootcollection_size(); i++) {
    total_size +=
      ::google::protobuf::internal::WireFormatLite::MessageSizeNoVirtual(
        this->slootcollection(i));
  }

  if (!unknown_fields().empty()) {
    total_size +=
      ::google::protobuf::internal::WireFormat::ComputeUnknownFieldsSize(
        unknown_fields());
  }
  GOOGLE_SAFE_CONCURRENT_WRITES_BEGIN();
  _cached_size_ = total_size;
  GOOGLE_SAFE_CONCURRENT_WRITES_END();
  return total_size;
}

void SlootCollectionList::MergeFrom(const ::google::protobuf::Message& from) {
  GOOGLE_CHECK_NE(&from, this);
  const SlootCollectionList* source =
    ::google::protobuf::internal::dynamic_cast_if_available<const SlootCollectionList*>(
      &from);
  if (source == NULL) {
    ::google::protobuf::internal::ReflectionOps::Merge(from, this);
  } else {
    MergeFrom(*source);
  }
}

void SlootCollectionList::MergeFrom(const SlootCollectionList& from) {
  GOOGLE_CHECK_NE(&from, this);
  slootcollection_.MergeFrom(from.slootcollection_);
  mutable_unknown_fields()->MergeFrom(from.unknown_fields());
}

void SlootCollectionList::CopyFrom(const ::google::protobuf::Message& from) {
  if (&from == this) return;
  Clear();
  MergeFrom(from);
}

void SlootCollectionList::CopyFrom(const SlootCollectionList& from) {
  if (&from == this) return;
  Clear();
  MergeFrom(from);
}

bool SlootCollectionList::IsInitialized() const {

  return true;
}

void SlootCollectionList::Swap(SlootCollectionList* other) {
  if (other != this) {
    slootcollection_.Swap(&other->slootcollection_);
    std::swap(_has_bits_[0], other->_has_bits_[0]);
    _unknown_fields_.Swap(&other->_unknown_fields_);
    std::swap(_cached_size_, other->_cached_size_);
  }
}

::google::protobuf::Metadata SlootCollectionList::GetMetadata() const {
  protobuf_AssignDescriptorsOnce();
  ::google::protobuf::Metadata metadata;
  metadata.descriptor = SlootCollectionList_descriptor_;
  metadata.reflection = SlootCollectionList_reflection_;
  return metadata;
}


// @@protoc_insertion_point(namespace_scope)

}  // namespace model
}  // namespace cg2d
}  // namespace laex
}  // namespace com

// @@protoc_insertion_point(global_scope)