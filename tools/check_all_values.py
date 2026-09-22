import os
import xml.etree.ElementTree as ET

for root, dirs, files in os.walk('apktool_smali/res'):
    if 'values' in root:
        for f in files:
            if f.endswith('.xml'):
                p = os.path.join(root, f)
                try:
                    tree = ET.parse(p)
                    for elem in tree.getroot():
                        txt = elem.text or ''
                        if any(k in txt.lower() for k in ["let's", "talksign", "let’s"]):
                            print(f"{p} -> {elem.get('name')}: {txt}")
                except Exception as e:
                    pass
