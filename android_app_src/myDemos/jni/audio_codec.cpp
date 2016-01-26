

#include <cstdint>
#include "audio_codec.h"
#include "native_common_header.h"

#ifdef __cplusplus
extern "C"
{
#endif

#define AUDIO_CODEC_EXTERN
#define AUDIO_CODEC_API


//==============================================================================
/// @brief: ������Ƶ������
/// @param: uint32_t codec_type ����
/// @param: uint16_t sample_rate ����Ƶ��
/// @param: uint16_t channel Ƶ������
/// @param: uint16_t sample_size ��������
/// @param: uint16_t bitrate ����
/// @return:��Ƶ���������
///=============================================================================
AUDIO_CODEC_EXTERN audio_encoder_t AUDIO_CODEC_API 
	create_audio_encoder(audio_codec_type_t codec_type, uint16_t sample_rate, 
	uint16_t channel, uint16_t sample_size, uint16_t bitrate)
{
	LOGD("wangtonggui test create_audio_encoder %d", codec_type);
}

//==============================================================================
/// @brief: ������Ƶ������
/// @param: audio_encoder_t handle ��Ƶ���������
/// @return:0-�ɹ� other-ʧ��
///=============================================================================
AUDIO_CODEC_EXTERN int32_t AUDIO_CODEC_API 
	destroy_audio_encoder(audio_encoder_t handle)
{
	LOGD("wangtonggui test create_audio_encoder %d", handle);
}

//==============================================================================
/// @brief: �����չ���ݳ���
/// @param: audio_encoder_t handle ��Ƶ���������
/// @return:��չ���ݳ���
///=============================================================================
AUDIO_CODEC_EXTERN uint32_t AUDIO_CODEC_API 
	audio_encoder_extradata_size(audio_encoder_t handle)
{
	LOGD("wangtonggui test audio_encoder_extradata_size %d", handle);
}

//==============================================================================
/// @brief: �����չ����
/// @param: video_encoder_t handle ��Ƶ���������
/// @param: uint8_t* extradata ��չ����ָ��
/// @param: uint32_t extradata_size ��չ���ݳ���
/// @return:��չ���ݳ���
///=============================================================================
AUDIO_CODEC_EXTERN uint32_t AUDIO_CODEC_API 
	audio_encoder_extradata(audio_encoder_t handle, 
	uint8_t* extradata, uint32_t extradata_size)
{
	LOGD("wangtonggui test audio_encoder_extradata %d/%d/%d", handle, extradata[0], extradata_size);
	extradata[0] = 100;
}

//==============================================================================
/// @brief: ��Ƶ����
/// @param: audio_encoder_t handle ��Ƶ���������
/// @param: const uint8_t* in �����������
/// @param: uint32_t in_size ����������ݳ���
/// @param: uint8_t* out ���������ݻ�����
/// @param: uint32_t out_size ���������ݻ���������
/// @return:��������ݳ���
///=============================================================================
AUDIO_CODEC_EXTERN uint32_t AUDIO_CODEC_API 
	audio_encoder_encode(audio_encoder_t handle, 
	const uint8_t* in, uint32_t in_size, uint8_t* out, uint32_t out_size)
{
	out[0] = 125;
	LOGD("audio_encoder_encode %d/%d/%d/%d/%d", handle, in[0], in_size, out[0], out_size);
}

//==============================================================================
/// @brief: ������Ƶ������
/// @param: uint32_t codec_type ����
/// @param: uint16_t sample_rate ����Ƶ��
/// @param: uint16_t channel Ƶ������
/// @param: uint16_t sample_size ��������
/// @return:��Ƶ���������
///=============================================================================
AUDIO_CODEC_EXTERN audio_decoder_t AUDIO_CODEC_API 
	create_audio_decoder(audio_codec_type_t codec_type, uint16_t sample_rate, 
	uint16_t channel, uint16_t sample_size)
{
	
}

//==============================================================================
/// @brief: ������Ƶ������
/// @param: audio_encoder_t handle ��Ƶ���������
/// @return:0-�ɹ� other-ʧ��
///=============================================================================
AUDIO_CODEC_EXTERN int32_t AUDIO_CODEC_API 
	destroy_audio_decoder(audio_decoder_t handle)
{
	
}

//==============================================================================
/// @brief: ��Ƶ����
/// @param: audio_decoder_t handle ��Ƶ���������
/// @param: const uint8_t* in �����������
/// @param: uint32_t in_size ����������ݳ���
/// @param: uint8_t* out ���������ݻ�����
/// @param: uint32_t out_size ���������ݻ���������
/// @return:��������ݳ���
///=============================================================================
AUDIO_CODEC_EXTERN uint32_t AUDIO_CODEC_API 
	audio_decoder_decode(audio_decoder_t handle, 
	const uint8_t* in, uint32_t in_size, uint8_t* out, uint32_t out_size)
{
	
}

#ifdef __cplusplus
};
#endif
