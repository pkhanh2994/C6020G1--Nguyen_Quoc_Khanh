drop database if exists manager_blog;
create database manager_blog;
use manager_blog;

create table blog( id varchar(30),blog_name varchar(255), blog_content text);

insert into blog values("blog-1","3107","Đêm dần buông, chỉ có đôi ta đứng đây hơi buồn
Nhấm nháp những suy tư của ngày hôm qua vừa đây...đã xa
Riêng mình ta...vẫn mãi lang thang dưới ánh chiều tà
Vẫn nổi nhớ miên man...ký ức bên em bây giờ đang ở một nơi xa
Chỉ cần bên nhau như những ngày ấy, anh sẽ cùng em đi hết tháng ngày
Để trong cơn mơ anh chẳng tìm thấy, để anh bơ vơ mãi phút nơi đây
Tình yêu khi xưa đôi ta vụn vỡ, trong một chiều mưa hai đứa chia tay
Chỉ cần cho anh được thêm một chút
Cho anh được gần bên em... ");

