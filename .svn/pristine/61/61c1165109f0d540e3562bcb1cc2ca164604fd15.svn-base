package com.tj720.admin.common.util;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;
 
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.w3c.dom.Document;
 
/**
 * DOC/DOCX文件转换为Html
 * <p>ClassName: Convert</p>
 * 
 * 
 */
public class Convert {
 
    public static void docxToHtml(String path, String file) throws Throwable {
        InputStream input = new FileInputStream(path + file);
        XWPFDocument document = new XWPFDocument(input);
        XHTMLOptions options = XHTMLOptions.create();
        File imageFolder = new File(path);
        // 设置图片生成路径
        options.setExtractor(new FileImageExtractor(imageFolder));
        // 设置图片链接，去掉后使用相对路径
        // options.URIResolver(new FileURIResolver(imageFolder));
        OutputStream out = new FileOutputStream(new File(path + "index.html"));
        XHTMLConverter.getInstance().convert(document, out, options);
    }
 
    /**
     * Convert doc to HTML
     * @param path
     * @param file
     * @throws Throwable
     */
    public static void docToHtml(String path, String file) throws Throwable {
        InputStream input = new FileInputStream(path + file);
        HWPFDocument wordDocument = new HWPFDocument(input);
        WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
        wordToHtmlConverter.setPicturesManager(new PicturesManager() {
            public String savePicture(byte[] content, PictureType pictureType, String suggestedName, float widthInches, float heightInches) {
                return suggestedName;
            }
        });
        wordToHtmlConverter.processDocument(wordDocument);
        List<?> pics = wordDocument.getPicturesTable().getAllPictures();
        if (pics != null) {
            for (int i = 0; i < pics.size(); i++) {
                Picture pic = (Picture) pics.get(i);
                FileOutputStream fout = null;
                try {
                	fout = new FileOutputStream(path + pic.suggestFullFileName());
                    pic.writeImageContent(fout);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } finally {
                	if (fout != null) {
                		fout.close();
                	}
                }
            }
        }
        Document htmlDocument = wordToHtmlConverter.getDocument();
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        DOMSource domSource = new DOMSource(htmlDocument);
        StreamResult streamResult = new StreamResult(outStream);
 
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer serializer = tf.newTransformer();
        serializer.setOutputProperty(OutputKeys.ENCODING, "GB2312");
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
        serializer.setOutputProperty(OutputKeys.METHOD, "html");
        serializer.transform(domSource, streamResult);
        outStream.close();
        String content = new String(outStream.toByteArray());
        writeFile(content, path + "index.html", "GB2312");
    }
 
    /**
     * 生成Html文件
     * @param content
     * @param path
     * @param encode
     */
    public static void writeFile(String content, String path, String encode) {
        FileOutputStream fos = null;
        BufferedWriter bw = null;
        try {
            File file = new File(path);
            fos = new FileOutputStream(file);
            bw = new BufferedWriter(new OutputStreamWriter(fos, encode));
            bw.write(content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ie) {
                ie.printStackTrace();
            }
        }
    }
}
