ANDROID_TOOLCHAIN_HOME=/d/program/toolchain
ANDROID_SYSROOT_HOME=${ANDROID_TOOLCHAIN_HOME}/sysroot
ANDROID_CROSS_COMPILE=${ANDROID_TOOLCHAIN_HOME}/bin/arm-linux-androideabi-

CXX=${ANDROID_CROSS_COMPILE}g++
AR=${ANDROID_CROSS_COMPILE}ar -rsc

CUR_DIR=$(PWD)
PROJ_DIR=$(CUR_DIR)/../../../..
OUTPUT_DIR=$(CUR_DIR)/../../output

DEPENDS_PATH=$(CUR_DIR)/../../depends

LIBEVENT_HOME=$(DEPENDS_PATH)/libevent
ASYNCCORE_HOME=$(DEPENDS_PATH)/libasynccore

INCLUDE=-I$(PROJ_DIR)/include -I$(ASYNCCORE_HOME)/include -I$(LIBEVENT_HOME)/include
LIBS=-L$(ASYNCCORE_HOME)/lib -L$(LIBEVENT_HOME)/lib -Wl,--whole-archive -lasynccored -levent -levent_pthreads -Wl,--no-whole-archive
SHARED=-shared
FPIC=-fPIC
MACRO=-D__STDC_FORMAT_MACROS -DANDROID -DHAVE_PTHREAD -D_U -mfpu=neon -mfloat-abi=softfp
CFLAGS=-g -Wall -O0 -std=c++11 ${MACRO} --sysroot=${ANDROID_SYSROOT_HOME}

OBJECT=$(patsubst %.cpp,%.o,$(wildcard $(PROJ_DIR)/src/*.cpp))
BIN=$(OUTPUT_DIR)/libstream_transferd.so

$(shell mkdir -p ${OUTPUT_DIR})

.PHONE: all clean test
all:$ $(BIN)

$(BIN):$(OBJECT)
	@echo compiling $@
	$(CXX) $(CFLAGS) $(INCLUDE) $(LIBS) ${SHARED} ${FPIC} $^ -o $@

$(OBJECT):
	@echo compiling $(@:%.o=%.cpp)
	$(CXX) -c $(INCLUDE) $(CFLAGS) ${SHARED} $(LIBS) $(FPIC) $(@:%.o=%.cpp) -o $@

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
