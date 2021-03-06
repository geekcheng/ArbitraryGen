package cc.suitalk.arbitrarygen.analyzer.reader;

import java.io.IOException;

import cc.suitalk.arbitrarygen.analyzer.IReader;
import cc.suitalk.arbitrarygen.core.Word;
import cc.suitalk.arbitrarygen.core.KeyWords.Sign.Type;
import cc.suitalk.arbitrarygen.core.Word.WordType;

/**
 * 
 * @author AlbieLiang
 *
 */
public class StringReader extends BaseWordReader {

	@Override
	public Word read(IReader reader, char prefix) {
		StringBuilder builder = new StringBuilder();
		Word word = new Word();
		WordType type = Word.WordType.STRING;
		char c = '\0';
		builder.append(prefix);
		try {
			while ((c = nextChar(reader)) != DOC_END_MARK) {
				if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')
						|| (c == '_') || (c == '$') || (c >= '0' && c <= '9')) {
					builder.append(c);
				} else {
					break;
				}
			}
			word.value = builder.toString();
			word.mark = Type.NORMAL;
		} catch (IOException e) {
			type = WordType.ERROR;
			e.printStackTrace();
		}
		word.type = type;
		return word;
	}

}
