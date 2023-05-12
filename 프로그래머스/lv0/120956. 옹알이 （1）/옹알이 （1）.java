class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        int canswer = 0;
        String chk = "";
        String[] temp = {"aya","ye","woo","ma"};
        for(int i = 0; i < babbling.length; i++){
            for(int j = 0; j < babbling[i].length(); j++){
                System.out.println(babbling[i]);
                if(babbling[i].length() < 2){
                    System.out.println("under2");
                    canswer = 0;
                    break;
                }else if(babbling[i].charAt(j) == 'a'){
                    if(j + 2 >= babbling[i].length()){
                        System.out.println("overindex");
                        canswer = 0;
                        break;
                    }
                    System.out.println("first a");
                    chk = Character.toString(babbling[i].charAt(j)) + Character.toString(babbling[i].charAt(j+1)) + Character.toString(babbling[i].charAt(j+2));
                    System.out.println(chk);
                    if(chk.equals(temp[0])){
                        System.out.println("chk++");
                        canswer = 1;
                        j = j + 2;
                    }else{
                        System.out.println("notchk");
                        canswer = 0;
                        break;
                    }
                }else if(babbling[i].charAt(j) == 'y'){
                    if(j + 1 >= babbling[i].length()){
                        System.out.println("overindex");
                        canswer = 0;
                        break;
                    }
                    System.out.println("first y");
                    chk = Character.toString(babbling[i].charAt(j)) + Character.toString(babbling[i].charAt(j+1));
                    if(chk.equals(temp[1])){
                        System.out.println("chk++");
                        canswer = 1;
                        j = j + 1;
                    }else{
                        System.out.println("notchk");
                        canswer = 0;
                        break;
                    }
                }else if(babbling[i].charAt(j) == 'w'){
                    if(j + 2 >= babbling[i].length()){
                        System.out.println("overindex");
                        canswer = 0;
                        break;
                    }
                    System.out.println("first w");
                    chk = Character.toString(babbling[i].charAt(j)) + Character.toString(babbling[i].charAt(j+1)) + Character.toString(babbling[i].charAt(j+2));
                    if(chk.equals(temp[2])){
                        System.out.println("chk++");
                        canswer = 1;
                        j = j + 2;
                    }else{
                        System.out.println("notchk");
                        canswer = 0;
                        break;
                    }
                }else if(babbling[i].charAt(j) == 'm'){
                    if(j + 1 >= babbling[i].length()){
                        System.out.println("overindex");
                        canswer = 0;
                        break;
                    }
                    System.out.println("first m");
                    chk = Character.toString(babbling[i].charAt(j)) + Character.toString(babbling[i].charAt(j+1));
                    if(chk.equals(temp[3])){
                        System.out.println("chk++");
                        canswer = 1;
                        j = j + 1;
                    }else{
                        System.out.println("notchk");
                        canswer = 0;
                        break;
                    }
                }else{
                    System.out.println("else");
                    canswer = 0;
                    break;
                }
            }
            if(canswer == 1){
                answer++;
                canswer = 0;
            }
        }
        return answer;
    }
}