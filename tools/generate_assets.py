import os
from PIL import Image, ImageDraw

def create_circular_icon(img):
    # Supersample for smooth circular anti-aliasing
    size = img.size[0]
    scale = 4
    large_size = size * scale
    large_img = img.resize((large_size, large_size), Image.Resampling.LANCZOS).convert("RGBA")
    
    mask = Image.new("L", (large_size, large_size), 0)
    draw = ImageDraw.Draw(mask)
    draw.ellipse((0, 0, large_size - 1, large_size - 1), fill=255)
    
    large_img.putalpha(mask)
    return large_img.resize((size, size), Image.Resampling.LANCZOS)

def create_fitted(img, target_w, target_h, pad_color=(255, 255, 255, 0)):
    # Fit img within target_w x target_h, preserving aspect ratio, centered
    iw, ih = img.size
    ratio = min(target_w / iw, target_h / ih)
    nw, nh = int(iw * ratio), int(ih * ratio)
    resized = img.resize((nw, nh), Image.Resampling.LANCZOS).convert("RGBA")
    
    canvas = Image.new("RGBA", (target_w, target_h), pad_color)
    ox = (target_w - nw) // 2
    oy = (target_h - nh) // 2
    canvas.paste(resized, (ox, oy), resized)
    return canvas

def main():
    base_dir = "apktool_smali/res"
    mouna_src = Image.open("mouna.png").convert("RGBA")
    
    # 1. Launcher Mipmaps
    densities = {
        "mdpi": (48, 108),
        "hdpi": (72, 162),
        "xhdpi": (96, 216),
        "xxhdpi": (144, 324),
        "xxxhdpi": (192, 432)
    }
    
    for density, (icon_size, fg_size) in densities.items():
        folder = os.path.join(base_dir, f"mipmap-{density}")
        os.makedirs(folder, exist_ok=True)
        
        # ic_launcher.webp
        icon = mouna_src.resize((icon_size, icon_size), Image.Resampling.LANCZOS)
        icon.save(os.path.join(folder, "ic_launcher.webp"), "WEBP", quality=100)
        
        # ic_launcher_round.webp
        round_icon = create_circular_icon(icon)
        round_icon.save(os.path.join(folder, "ic_launcher_round.webp"), "WEBP", quality=100)
        
        # ic_launcher_foreground.webp (adaptive icon foreground, 72dp inside 108dp)
        fg_inner = int(fg_size * (72 / 108))
        inner_logo = mouna_src.resize((fg_inner, fg_inner), Image.Resampling.LANCZOS)
        fg_canvas = Image.new("RGBA", (fg_size, fg_size), (0, 0, 0, 0))
        ox = (fg_size - fg_inner) // 2
        oy = (fg_size - fg_inner) // 2
        fg_canvas.paste(inner_logo, (ox, oy), inner_logo)
        fg_canvas.save(os.path.join(folder, "ic_launcher_foreground.webp"), "WEBP", quality=100)
        print(f"Generated mipmap-{density} icons ({icon_size}px, fg {fg_size}px)")

    # 2. In-app drawables
    drawables = [
        ("drawable/lts_logo.png", 540, 474),
        ("drawable/lts_logo_hd.png", 1070, 782),
        ("drawable/small_logo.png", 58, 62),
        ("drawable-mdpi/small_logo1.png", 116, 124),
        ("drawable-mdpi/small_logo2.png", 116, 124),
        ("drawable-mdpi/small_logo3.png", 116, 124),
        ("drawable-nodpi/logo.png", 400, 400),
        ("drawable/lets_tts.png", 225, 184),
        ("drawable/dvt_logo_hd.png", 1070, 782),
        ("drawable/mouna_logo.png", 512, 512)
    ]
    
    for rel_path, w, h in drawables:
        dest_path = os.path.join(base_dir, rel_path)
        os.makedirs(os.path.dirname(dest_path), exist_ok=True)
        fitted = create_fitted(mouna_src, w, h)
        fitted.save(dest_path, "PNG")
        print(f"Generated {rel_path} ({w}x{h})")

if __name__ == "__main__":
    main()
