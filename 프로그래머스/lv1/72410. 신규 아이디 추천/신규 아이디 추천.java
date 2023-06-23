class Solution {
    public String solution(String new_id) {
        String rcd_id = new_id.toLowerCase()
            .replaceAll("[^\\w\\-_.]", "")
            .replaceAll("[\\.]+", ".");
        if(rcd_id.startsWith(".")){
            rcd_id = rcd_id.substring(1);
        }
        if(rcd_id.endsWith(".")){
            rcd_id = rcd_id.substring(0, rcd_id.length() - 1);
        }
        if(rcd_id.length() == 0){
            rcd_id = "aaa";
        } else if(rcd_id.length() > 15) {
            rcd_id = rcd_id.substring(0, 15);
            if(rcd_id.endsWith(".")){
                rcd_id = rcd_id.substring(0, rcd_id.length() - 1);
            }
        } else if(rcd_id.length() < 3){
            while(rcd_id.length() < 3){
                rcd_id += rcd_id.charAt(rcd_id.length() - 1);
            }
        }
        
        return rcd_id;
    }
}