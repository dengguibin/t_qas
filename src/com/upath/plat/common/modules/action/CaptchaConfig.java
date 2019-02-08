package com.upath.plat.common.modules.action;

import java.awt.Color;
import java.awt.image.BufferedImage;

import com.github.bingoohuang.patchca.background.BackgroundFactory;
import com.github.bingoohuang.patchca.color.SingleColorFactory;
import com.github.bingoohuang.patchca.filter.predefined.WobbleRippleFilterFactory;
import com.github.bingoohuang.patchca.font.RandomFontFactory;
import com.github.bingoohuang.patchca.service.AbstractCaptchaService;
import com.github.bingoohuang.patchca.text.renderer.BestFitTextRenderer;
import com.github.bingoohuang.patchca.word.RandomWordFactory;


/**
 * 验证码的实现类
 * @author upaths
 * version 1.0.0
 * create date :2013-7-4 upath 代码生成平台
 * 联系邮箱： upaths@163.com
 * 项目托管地址：https://code.google.com/p/upath/
 * 修改时间：
 */
public class CaptchaConfig extends AbstractCaptchaService  {

	
		public CaptchaConfig(){
			//文本内容
			wordFactory = new WordFactory();
			//字体
			fontFactory = new RandomFontFactory();
			RandomFontFactory ff = (RandomFontFactory)fontFactory;
			ff.setRandomStyle(false);
			ff.setMaxSize(20);  
			ff.setMinSize(20); 
			//效果
			textRenderer = new BestFitTextRenderer();
			//背景 不需要进行背景 透明底
			backgroundFactory = new BackgroundFactory() {
				public void fillBackground(BufferedImage dest) {
					
				}
			};
			//字体颜色
			colorFactory = new SingleColorFactory(new Color(0, 0, 0));
			//样式(曲线波纹加干扰线)
			filterFactory = new WobbleRippleFilterFactory();
			//图片长宽
			width = 70;
			height = 25;
		}
		class WordFactory extends RandomWordFactory {
			public WordFactory(){
				//文本范围和长度
				characters = "AabBcCDeEeFfGgHhJKLsdekmnwx23456789";
				minLength = 4;
				maxLength = 4;
			}
		}
}
