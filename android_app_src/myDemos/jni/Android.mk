#=======开始格式
LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

#=======native模块（可以算为模板）
LOCAL_MODULE    := native_center
LOCAL_SRC_FILES := native_center.cpp
LOCAL_SRC_FILES += audio_codec.cpp
LOCAL_SRC_FILES += video_codec.cpp

#=======配置版本类型
#debug
#LOCAL_CFLAGS += -g -D_DEBUG -DP2P_LOG
#release
#LOCAL_CFLAGS += -O2 -DNDEBUG
#=======配置jni层的日志需要的so
LOCAL_LDLIBS    := -lm -llog
#=======配置头文件目录
LOCAL_C_INCLUDES := sources/foo



include $(BUILD_SHARED_LIBRARY)