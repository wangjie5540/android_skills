#开始格式
LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

#native模块（可以算为模板）
LOCAL_MODULE    := native_center
LOCAL_SRC_FILES := native_center.cpp
LOCAL_SRC_FILES += audio_codec.cpp
LOCAL_SRC_FILES += video_codec.cpp

LOCAL_LDLIBS    := -lm -llog

LOCAL_C_INCLUDES := sources/foo
include $(BUILD_SHARED_LIBRARY)