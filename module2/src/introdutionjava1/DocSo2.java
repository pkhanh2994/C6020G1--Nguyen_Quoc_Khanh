package introdutionjava1;
import java.util.Scanner;

public class DocSo2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập số cần đọc:");
        int so=scanner.nextInt();
        int hangChuc;
        int donvi;
        int hang20;
        int hangtram;
        hang20=so/10;
        donvi=so%10;
        hangtram=so/100;
        if(so>=0&&so<=10){
            switch (so){
                case 0:
                    System.out.print("zero");
                    break;
                case 1:
                    System.out.print("one");
                    break;
                case 2:
                    System.out.print("two");
                    break;
                case 3:
                    System.out.print("three");
                    break;
                case 4:
                    System.out.print("four");
                    break;
                case 5:
                    System.out.print("five");
                    break;
                case 6:
                    System.out.print("six");
                    break;
                case 7:
                    System.out.print("seven");
                    break;
                case 8:
                    System.out.print("eight");
                    break;
                case 9:
                    System.out.print("night");
                    break;
                case 10:
                    System.out.print("ten");
                    break;

            }
        }else {
            if(so>10&&so<20){
                hangChuc=so%10;
                switch (hangChuc){
                    case 1:
                        System.out.print("eleven");
                        break;
                    case 2:
                        System.out.print("twelve");
                        break;
                    case 3:
                        System.out.print("thirteen");
                        break;
                    case 4:
                        System.out.print("fourteen");
                        break;
                    case 5:
                        System.out.print("fifteen");
                        break;
                    case 6:
                        System.out.print("sixteen");
                        break;
                    case 7:
                        System.out.print("seventeen");
                        break;
                    case 8:
                        System.out.print("eighteen");
                        break;
                    case 9:
                        System.out.print("nineteen");
                        break;
                }
            }else {
                if(so>=20&&so<100){
                    switch (hang20){
                        case 2:
                            System.out.print("twenty\t");
                            break;
                        case 3:
                            System.out.print("thirty\t");
                            break;
                        case 4:
                            System.out.print("forty\t");
                            break;
                        case 5:
                            System.out.print("fifty\t");
                            break;
                        case 6:
                            System.out.print("sixty\t");
                            break;
                        case 7:
                            System.out.print("seventy\t");
                            break;
                        case 8:
                            System.out.print("eighty\t");
                            break;
                        case 9:
                            System.out.print("ninety\t");
                            break;
                    }
                    switch (donvi){
                        case 1:
                            System.out.print("one");
                            break;
                        case 2:
                            System.out.print("two");
                            break;
                        case 3:
                            System.out.print("three");
                            break;
                        case 4:
                            System.out.print("four");
                            break;
                        case 5:
                            System.out.print("five");
                            break;
                        case 6:
                            System.out.print("six");
                            break;
                        case 7:
                            System.out.print("seven");
                            break;
                        case 8:
                            System.out.print("eight");
                            break;
                        case 9:
                            System.out.print("night");
                            break;
                    }

                }else {
                    if(so>=100&&so<1000){
                        int donvi2=so%100;
                        switch (hangtram){
                            case 1:
                                System.out.print("one hundred ");
                                break;
                            case 2:
                                System.out.print("two hundred ");
                                break;
                            case 3:
                                System.out.print("three hundred ");
                                break;
                            case 4:
                                System.out.print("four hundred ");
                                break;
                            case 5:
                                System.out.print("five hundred ");
                                break;
                            case 6:
                                System.out.print("six hundred ");
                                break;
                            case 7:
                                System.out.print("seven hundred ");
                                break;
                            case 8:
                                System.out.print("eight hundred ");
                                break;
                            case 9:
                                System.out.print("nine hundred ");
                                break;
                        }

                        switch (donvi2){
                            case 1:
                                System.out.print("and one");
                                break;
                            case 2:
                                System.out.print("and two");
                                break;
                            case 3:
                                System.out.print("and three");
                                break;
                            case 4:
                                System.out.print("and four");
                                break;
                            case 5:
                                System.out.print("and five");
                                break;
                            case 6:
                                System.out.print("and six");
                                break;
                            case 7:
                                System.out.print("and seven");
                                break;
                            case 8:
                                System.out.print("and eight");
                                break;
                            case 9:
                                System.out.print("and night");
                                break;
                            case 10:
                                System.out.print("and ten");
                                break;

                        }

                    }
                }
            }
        }
    }
}
