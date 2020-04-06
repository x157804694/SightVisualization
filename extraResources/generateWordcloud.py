import sys
import wordcloud
from imageio import imread

mask=imread('D:/pyInterface/chinamap.jpg')
path=sys.argv[1]
if not path.endswith('/'):
	path=path+'/'
wordcloud=wordcloud.WordCloud(background_color=None, mode="RGBA",width=1000,height=700\
                              ,font_path='msyh.ttc',mask=mask)
wordcloud.generate(sys.argv[3])
#print("len="+str(len(sys.argv[3])))
wordcloud.to_file(path+sys.argv[2]+'.png')