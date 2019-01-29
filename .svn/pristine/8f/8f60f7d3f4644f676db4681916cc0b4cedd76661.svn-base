package com.tj720.admin.common.util;


import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


@Component
@Slf4j
public class WordToHtml {

	public static void convertWordToHtml(String filePath,String fileName) throws IOException, ParserConfigurationException, TransformerException {

		String htmlPath = filePath + "index.html";
		String imagePath = filePath;
		String path = filePath + fileName;

		if (StringUtils.isBlank(path)) {
			return;
		}

		XWPFDocument document = new XWPFDocument(new FileInputStream(path));
		XHTMLOptions options = XHTMLOptions.create();
		options.setExtractor(new FileImageExtractor(new File(imagePath)));
		//            options.URIResolver(new BasicURIResolver(""));

		@Cleanup OutputStreamWriter streamWriter = new OutputStreamWriter(new FileOutputStream(htmlPath));
		XHTMLConverter xhtmlConverter = (XHTMLConverter) XHTMLConverter.getInstance();
		xhtmlConverter.convert(document, streamWriter, options);
	}
	
	public static void docToHtml(String filePath,String fileName) throws IOException, ParserConfigurationException, TransformerException {
		
		String htmlPath = filePath + "index.html";
		String imagePath = filePath;
		String path = filePath + fileName;
		
		HWPFDocument wordDocument = new HWPFDocument(new FileInputStream(path));
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(document);
        // 保存图片，并返回图片的相对路径
        wordToHtmlConverter.setPicturesManager((content, pictureType, name, width, height) -> {
            File imageFile = new File(imagePath);
            if(!imageFile.exists()){
                imageFile.mkdirs();
            }
            try (FileOutputStream out = new FileOutputStream(imagePath + name)) {
                out.write(content);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return name;
        });
        wordToHtmlConverter.processDocument(wordDocument);
        Document htmlDocument = wordToHtmlConverter.getDocument();
        DOMSource domSource = new DOMSource(htmlDocument);
        StreamResult streamResult = new StreamResult(new File(htmlPath));

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer serializer = tf.newTransformer();
        serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
        serializer.setOutputProperty(OutputKeys.METHOD, "html");
        serializer.transform(domSource, streamResult);
	}

}
