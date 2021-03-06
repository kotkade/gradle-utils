/*-
 * Copyright 2013 © Meikel Brandmeyer.
 * All rights reserved.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package kotka.gradle.utils

import java.io.File

/**
 * A utility class to help working with files.
 *
 * @author Meikel Brandmeyer
 */
class FileUtil {
    /**
     * Creates a child file under parent. It concatenates the given path
     * segments together and return the inner most child entry.
     *
     * @param  parent   the parent file
     * @param  segments segments describing the path to the child entry
     * @return          the child entry
     */
    static file(File parent, String... segments) {
        segments.inject(parent) { p, segment ->
            new File(p, segment)
        }
    }

    /**
     * Creates a child file under parent. It concatenates the given path
     * segments together and return the inner most child entry.
     *
     * @param  parent   the parent filename
     * @param  segments segments describing the path to the child entry
     * @return          the child entry
     */
    static file(String parent, String... segments) {
        segments.inject(new File(parent)) { p, segment ->
            new File(p, segment)
        }
    }

    /**
     * Deletes the given file. Directories are deleted recursively.
     *
     * @param  file The file to be removed.
     */
    static void remove(File f) {
        if (!f.exists())
            return

        if (f.isDirectory()) {
            f.listFiles().each { remove(it) }
        }

        f.delete()
    }

    /**
     * Deletes the given file. Directories are deleted recursively.
     *
     * @param  file The file to be removed.
     */
    static void remove(String f) {
        remove(new File(f))
    }
}
