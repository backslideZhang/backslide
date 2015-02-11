import java.util.*;

public class WordLadderII {

    public void solution() {
        String[] dicts = new String[]{"dose","ends","dine","jars","prow","soap","guns","hops","cray","hove","ella","hour","lens","jive","wiry","earl","mara","part","flue","putt","rory","bull","york","ruts","lily","vamp","bask","peer","boat","dens","lyre","jets","wide","rile","boos","down","path","onyx","mows","toke","soto","dork","nape","mans","loin","jots","male","sits","minn","sale","pets","hugo","woke","suds","rugs","vole","warp","mite","pews","lips","pals","nigh","sulk","vice","clod","iowa","gibe","shad","carl","huns","coot","sera","mils","rose","orly","ford","void","time","eloy","risk","veep","reps","dolt","hens","tray","melt","rung","rich","saga","lust","yews","rode","many","cods","rape","last","tile","nosy","take","nope","toni","bank","jock","jody","diss","nips","bake","lima","wore","kins","cult","hart","wuss","tale","sing","lake","bogy","wigs","kari","magi","bass","pent","tost","fops","bags","duns","will","tart","drug","gale","mold","disk","spay","hows","naps","puss","gina","kara","zorn","boll","cams","boas","rave","sets","lego","hays","judy","chap","live","bahs","ohio","nibs","cuts","pups","data","kate","rump","hews","mary","stow","fang","bolt","rues","mesh","mice","rise","rant","dune","jell","laws","jove","bode","sung","nils","vila","mode","hued","cell","fies","swat","wags","nate","wist","honk","goth","told","oise","wail","tels","sore","hunk","mate","luke","tore","bond","bast","vows","ripe","fond","benz","firs","zeds","wary","baas","wins","pair","tags","cost","woes","buns","lend","bops","code","eddy","siva","oops","toed","bale","hutu","jolt","rife","darn","tape","bold","cope","cake","wisp","vats","wave","hems","bill","cord","pert","type","kroc","ucla","albs","yoko","silt","pock","drub","puny","fads","mull","pray","mole","talc","east","slay","jamb","mill","dung","jack","lynx","nome","leos","lade","sana","tike","cali","toge","pled","mile","mass","leon","sloe","lube","kans","cory","burs","race","toss","mild","tops","maze","city","sadr","bays","poet","volt","laze","gold","zuni","shea","gags","fist","ping","pope","cora","yaks","cosy","foci","plan","colo","hume","yowl","craw","pied","toga","lobs","love","lode","duds","bled","juts","gabs","fink","rock","pant","wipe","pele","suez","nina","ring","okra","warm","lyle","gape","bead","lead","jane","oink","ware","zibo","inns","mope","hang","made","fobs","gamy","fort","peak","gill","dino","dina","tier"};
        Set<String> dict = new HashSet<String>(Arrays.asList(dicts));
        System.out.println(findLadders("nape", "mild", dict));
    }

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new LinkedList<List<String>>();
        if (dict.contains(start)) {
            dict.remove(start);
        }
        if (dict.contains(end)) {
            dict.remove(end);
        }
        int wordLen = start.length();
        if (start.equals(end)) {
            List<String> list = new ArrayList<String>();
            list.add(start);
            result.add(list);
        } else {
            int diff = 0;
            for (int i = 0; i < wordLen; i++) {
                if (start.charAt(i) != end.charAt(i)) {
                    diff++;
                    if (diff > 1) {
                        break;
                    }
                }
            }
            if (diff == 1) {
                List<String> list = new ArrayList<String>();
                list.add(start);
                list.add(end);
                result.add(list);
                return result;
            }
            List<String> endWords = new ArrayList<String>();
            for (String word : dict) {
                diff = 0;
                for (int i = 0; i < wordLen; i++) {
                    if (end.charAt(i) != word.charAt(i)) {
                        diff++;
                        if (diff > 1) {
                            break;
                        }
                    }
                }
                if (diff == 1) {
                    endWords.add(word);
                }
            }
            Queue<PathNode> queue = new LinkedList<PathNode>();
            List<PathNode> endPathNodes = new ArrayList<PathNode>();
            List<String> removeBuffer = new ArrayList<String>();
            int depth = 0;
            int finalDepth = dict.size();
            queue.add(new PathNode(start));
            while (!queue.isEmpty()) {
                PathNode previous = queue.poll();
                if (previous.depth >= finalDepth) {
                    continue;
                }
                if (previous.depth != depth) {
                    dict.removeAll(removeBuffer);
                    removeBuffer.clear();
                    depth = previous.depth;
                }
                if (dict.size() > 0) {
                    for (int i = 0; i < wordLen; i++) {
                        for (char ch='a'; ch <= 'z'; ch++) {
                            char[] charArray = previous.current.toCharArray();
                            if (charArray[i] == ch) {
                                continue;
                            }
                            charArray[i] = ch;
                            String newWord = new String(charArray);
                            if (dict.contains(newWord)) {
                                PathNode node = new PathNode(newWord);
                                node.previous = previous;
                                node.depth = previous.depth + 1;
                                removeBuffer.add(newWord);
                                if (!endWords.contains(newWord)) {
                                    queue.add(node);
                                } else {
                                    endPathNodes.add(node);
                                    finalDepth = node.depth;
                                }

                            }
                        }
                    }
                }
            }
            for (PathNode endPathNode : endPathNodes) {
                List<String> path = new ArrayList<String>();
                path.add(end);
                PathNode pathNode = endPathNode;
                while (pathNode != null) {
                    path.add(pathNode.current);
                    pathNode = pathNode.previous;
                }
                result.add(path);
            }
        }
        return result;
    }

    public class PathNode {
        public String current = null;
        public PathNode previous = null;
        public int depth = 0;

        public PathNode(String current) {this.current = current;}
    }
}
