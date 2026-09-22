from PIL import Image, ImageDraw, ImageFont
import os

def generate_splash_logo():
    canvas_w, canvas_h = 900, 900
    canvas = Image.new("RGBA", (canvas_w, canvas_h), (0, 0, 0, 0))
    
    # 1. Load mouna emblem
    mouna_src = Image.open("mouna.png").convert("RGBA")
    emblem_size = 520
    emblem = mouna_src.resize((emblem_size, emblem_size), Image.Resampling.LANCZOS)
    
    emblem_x = (canvas_w - emblem_size) // 2
    emblem_y = 60
    canvas.paste(emblem, (emblem_x, emblem_y), emblem)
    
    # 2. Draw Text "Mouna"
    draw = ImageDraw.Draw(canvas)
    font_path = "C:/Windows/Fonts/segoeuib.ttf"
    if not os.path.exists(font_path):
        font_path = "C:/Windows/Fonts/arialbd.ttf"
    
    title_font = ImageFont.truetype(font_path, 96)
    title_text = "Mouna"
    
    # Measure text
    left, top, right, bottom = draw.textbbox((0, 0), title_text, font=title_font)
    tw = right - left
    tx = (canvas_w - tw) // 2
    ty = emblem_y + emblem_size + 40
    
    # Draw sleek dark title
    draw.text((tx, ty), title_text, font=title_font, fill=(15, 23, 42, 255))
    
    # Subtitle font
    sub_font_path = "C:/Windows/Fonts/segoeui.ttf"
    if not os.path.exists(sub_font_path):
        sub_font_path = "C:/Windows/Fonts/arial.ttf"
    sub_font = ImageFont.truetype(sub_font_path, 36)
    sub_text = "Live Interpret"
    s_left, s_top, s_right, s_bottom = draw.textbbox((0, 0), sub_text, font=sub_font)
    sw = s_right - s_left
    sx = (canvas_w - sw) // 2
    sy = ty + 110
    
    draw.text((sx, sy), sub_text, font=sub_font, fill=(100, 116, 139, 255))
    
    dest1 = "apktool_smali/res/drawable/lts_logo_hd.png"
    dest2 = "apktool_smali/res/drawable/lts_logo.png"
    canvas.save(dest1, "PNG")
    canvas.save(dest2, "PNG")
    print(f"Saved splash brand logo to {dest1} and {dest2}")

if __name__ == "__main__":
    generate_splash_logo()
