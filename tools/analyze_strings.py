import os
import xml.etree.ElementTree as ET

tree = ET.parse('apktool_smali/res/values/strings.xml')
root = tree.getroot()

print("--- Matches in strings.xml ---")
for elem in root.findall('string'):
    name = elem.get('name', '')
    text = elem.text or ''
    t_lower = text.lower()
    if any(k in t_lower for k in ["talk", "let's", "let’s", "lts", "deep vision"]) or any(k in name.lower() for k in ['app_name', 'drawer_title', 'title']):
        print(f'{name} = "{text}"')
