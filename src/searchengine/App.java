package searchengine;

public class App {

    /*--------------------------------------------------------------------------------------------
     Typical search engine implemeting BTree and Bitmap with 4 document indicating 0,1 
     1 = keyworkd found in in the document id offset 
     0 = keyworkd not found in the document id offset
     */
    public static void main(String[] args) {

        BTree<String, String> index = new BTree<>();

        index.put("apple"    , "10000000");  // indexing term in document 1
        index.put("broccoli" , "10000000");  // indexing term in document 1
        index.put("orange"   , "01000000");  // indexing term in document 2
        index.put("cucumber" , "00100000");  // indexing term in document 3  
        index.put("carrot"   , "00010000");  // indexing term in document 4
        index.put("artichoke", "00010000");  // indexing term in document 4
        
        // Because we add broccoli in document 1 and document 5, the bitmap signature must change.
        // These changes cause indexing to slow down as more documents are added.
        index.put("broccoli",  "10001000");  // indexing term in document 5
        
        // Output: broccoli document offsets : 10001000
        // Now, we know that broccoli is document 1 and 5        
        System.out.println("broccoli document offsets : " + index.get("broccoli"));

        
        System.out.println("apple document offset     : " + index.get("apple"));
        System.out.println("orange document offset    : " + index.get("orange"));
        System.out.println("carrot document offset    : " + index.get("carrot"));

        System.out.println("size:    " + index.size());
        System.out.println("height:  " + index.height());
    }
    /*--------------------------------------------------------------------------------------------*/
}
