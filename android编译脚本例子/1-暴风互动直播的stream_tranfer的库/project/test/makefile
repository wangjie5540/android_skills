ANDROID_TOOLCHAIN_HOME=/opt/Software/devtools/android/arm-linux-androideabi-4.9
# ANDROID_TOOLCHAIN_HOME=E:/devtool/Android/toolchain
ANDROID_CROSS_COMPILE=${ANDROID_TOOLCHAIN_HOME}/bin/arm-linux-androideabi-

CXX=${ANDROID_CROSS_COMPILE}g++
AR=${ANDROID_CROSS_COMPILE}ar -rsc
RM=@rm -fr

CUR_DIR=$(PWD)
PROJ_DIR=$(CUR_DIR)/../../../../test
OUTPUT_DIR=$(CUR_DIR)/../../output

DEPENDS_PATH=$(CUR_DIR)/../../depends

LIBEVENT_HOME=$(DEPENDS_PATH)/libevent
ASYNCCORE_HOME=$(DEPENDS_PATH)/libasynccore
STREAM_TRANSFER_HOME=$(CUR_DIR)/../../../..

INCLUDE=-I$(STREAM_TRANSFER_HOME)/include -I$(PROJ_DIR)/av_codec -I$(ASYNCCORE_HOME)/include -I$(LIBEVENT_HOME)/include
LIBS=-L$(OUTPUT_DIR) -lstream_transferd
SHARED=-shared
FPIC=-fPIC
MACRO=-D__STDC_FORMAT_MACROS -D__STDC_LIMIT_MACROS -DANDROID -DHAVE_PTHREAD -mfpu=neon -mfloat-abi=softfp
CFLAGS=-g -Wall -O0 -std=c++11 ${MACRO}
#-gstabs+

EXCLUDE_OBJ:=$(PROJ_DIR)/live_media_encoder.o $(PROJ_DIR)/getopt.o

OBJECT=$(patsubst %.cpp,%.o,$(wildcard $(PROJ_DIR)/*.cpp))
OBJECT+=$(patsubst %.cpp,%.o,$(wildcard $(PROJ_DIR)/asynccore/*.cpp))
OBJECT+=$(patsubst %.cpp,%.o,$(wildcard $(PROJ_DIR)/av_codec/*.cpp))
OBJECT+=$(patsubst %.cpp,%.o,$(wildcard $(PROJ_DIR)/av_codec/av/common/*.cpp))
OBJECT+=$(patsubst %.cpp,%.o,$(wildcard $(PROJ_DIR)/av_codec/av/flv/*.cpp))
OBJECT+=$(patsubst %.cpp,%.o,$(wildcard $(PROJ_DIR)/av_codec/av/mp4/*.cpp))

OBJECT:=$(filter-out $(EXCLUDE_OBJ), $(OBJECT))

BIN=$(OUTPUT_DIR)/live_media_encoderd

$(shell mkdir -p ${OUTPUT_DIR})

.PHONE: all clean test
all:$ $(BIN)

$(BIN):$(OBJECT)
	@echo compiling $@
	$(CXX) $(CFLAGS) $(INCLUDE) $(LIBS) ${FPIC} $^ -o $@

$(OBJECT):
	@echo compiling $(@:%.o=%.cpp)
	$(CXX) -c $(INCLUDE) $(CFLAGS) $(LIBS) $(FPIC) $(@:%.o=%.cpp) -o $@

clean:
	$(RM) $(OBJECT)
	$(RM) $(BIN)
	$(RM) *~

test:
	@echo "PROJ_DIR=" $(PROJ_DIR)
	@echo "OUTPUT_DIR=" $(OUTPUT_DIR)
	@echo "INCLUDE=" $(INCLUDE)
	@echo "OBJECT=" $(OBJECT)
	@echo "BIN=" $(BIN)
