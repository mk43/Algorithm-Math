#include <stdio.h>
#include "jpeg_encoder.h"

int main(int argc, char* argv[])
{
    const char* inputFileName = "pic1.bmp";

	JpegEncoder encoder;
	// 读取BMP格式的文件
	if(!encoder.readFromBMP(inputFileName)) {
		return 1;
	}

	// 将BMP格式的文件按照JPEG标准压缩成JPEG文件
	if(!encoder.encodeToJPG("out.jpeg", 50)) {
	    printf("jpg\n");
		return 1;
	}

	return 0;
}
